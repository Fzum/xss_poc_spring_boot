# XSS POC Spring Boot
To prevent XSS attacks, the spring backend never returns HTML.
If no HTML should be returned at all from Backend, look at Section **Alternative with Jsoup**.

|                |Input								            |Output                         |
|----------------|-------------------------------|-----------------------------|
|Escaping Spring HtmlUtils|`<h1>hello world</h1>`            				|`&lt;h1&gt;hello world&gt;h1&lt;`          |
|Sanitize Jsoup|`<h1>hello world</h1>`            |`hello world`            |


## Add Module to Jackson Object Mapper
the jackson object mapper has been modified to escape html from string fields

Add Jackson-Module to application wide ObjectMapper - Spring Docs:
>Any beans of type com.fasterxml.jackson.databind.Module are automatically registered with the auto-configured Jackson2ObjectMapperBuilder and are applied to any ObjectMapper instances that it creates. This provides a global mechanism for contributing custom modules when you add new features to your application.

## Alternative with Jsoup
Maybe it is better to never return any html-code. In that case **[Jsoup](https://jsoup.org/)** would be good. That would also be better compared to the SpringUtil.htmlEscape Method since German Umlaute and other Sonderzeichen can not be escaped wrongly.

    package at.wienit.fimservice.io.config.xss;  
      
    import org.jsoup.safety.Whitelist;  
      
    import static org.jsoup.Jsoup.clean;  
    import static org.jsoup.Jsoup.isValid;  
    import static org.jsoup.safety.Whitelist.none;  

    public final class HtmlSanitizer {  
      private static final Whitelist WHITELIST = none();  
      
        public static String sanitize(String input) {  
	      if (isValid(input, WHITELIST)) {  
		      return input;  
          }  
      
	      return clean(input, WHITELIST);  
        }  
    }


