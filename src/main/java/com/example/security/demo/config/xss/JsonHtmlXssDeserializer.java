package com.example.security.demo.config.xss;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;
import java.util.Optional;

public class JsonHtmlXssDeserializer extends JsonDeserializer<String> {

    @Override
    public Class<String> handledType() {
        return String.class;
    }

    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return Optional.ofNullable(jsonParser.getValueAsString())
                .map(HtmlUtils::htmlEscape)
                .orElse(null);
    }
}
