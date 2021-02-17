package com.example.security.demo.encoder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.web.util.HtmlUtils.htmlEscape;

public class CSSEncoderTest {
    @Test
    @DisplayName("given string with html when encoding then sting has no html2")
    void givenStringWithHtmlWhenEncodingThenStingHasNoHtml2() {
        // given
        final String givenStringWithHtml = "<h1>hello world!</h1>";
        // when
        final String encodedString = htmlEscape(givenStringWithHtml);
        // then
        System.out.println(encodedString);
        assertAll(
                () -> assertFalse(encodedString.contains("<h1>")),
                () -> assertFalse(encodedString.contains("</h1>"))
        );
    }

    @Test
    @DisplayName("given string with javascript when encoding then string has no javascript2")
    void givenStringWithJavascriptWhenEncodingThenStringHasNoJavascript2() {
        // given
        final String givenStringWithJs = "<script>console.log('hello world')</script>";
        // when
        final String encodedString = htmlEscape(givenStringWithJs);
        // then
        System.out.println(encodedString);
        assertAll(
                () -> assertFalse(encodedString.contains("<script>")),
                () -> assertFalse(encodedString.contains("</script>"))
        );
    }
}
