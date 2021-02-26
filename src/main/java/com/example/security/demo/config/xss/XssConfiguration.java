package com.example.security.demo.config.xss;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class XssConfiguration {
    @Bean
    private Module xssModule() {
        return new SimpleModule("XSS-Module")
                .addSerializer(new JsonHtmlXssSerializer())
                .addDeserializer(String.class, new JsonHtmlXssDeserializer());
    }
}
