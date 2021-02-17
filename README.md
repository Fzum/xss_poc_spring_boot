# xss_poc_spring_boot
to prevent xss attacks, the spring backend never returns html. input = &lt;h1> => output = &amp;lt;h1&amp;gt:

## object mapper
the jackson object mapper has been modified to escape html from string fields
