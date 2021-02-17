package com.example.security.demo.config.xss;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.web.util.HtmlUtils;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.Optional;

public class JsonHtmlXssSerializer extends JsonSerializer<String> {

    public JsonHtmlXssSerializer() {
        super();
    }

    @Override
    public Class<String> handledType() {
        return String.class;
    }

    @Override
    public void serialize(String value, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        if (value != null) {
            String encodedValue = HtmlUtils.htmlEscape(value);
            jsonGenerator.writeString(encodedValue);
        }
    }
}
