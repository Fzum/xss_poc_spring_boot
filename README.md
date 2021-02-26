# xss_poc_spring_boot
to prevent xss attacks, the spring backend never returns html. input = &lt;h1> => output = &amp;lt;h1&amp;gt:

## object mapper
the jackson object mapper has been modified to escape html from string fields

Add Jackson-Module to application wide ObjectMapper - Spring Docs:
>Any beans of type com.fasterxml.jackson.databind.Module are automatically registered with the auto-configured Jackson2ObjectMapperBuilder and are applied to any ObjectMapper instances that it creates. This provides a global mechanism for contributing custom modules when you add new features to your application.
