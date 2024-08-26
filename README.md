# Bancroft
Authentication Failure

Hello my name is Andre and I am having trouble with a Spring Boot Project with Spring Security using two different login pages. The main problem right now is that the application is throwing this error:

java.lang.NullPointerException: Cannot invoke "org.springframework.security.core.Authentication.getAuthorities()" because "authentication" is null

I am using Spring Boot v3.3.0-RC1 and Spring Security 6.1.6. I am using a Windows 11 HP laptop, Postgres 16 on a local host, regular HTML web pages via Tomcat Server (NOT Thymeleaf or any other templating engine) and the Fetch API to retrieve data from the database. My code can be found on GitHub at:  Along with my SQL scripts.
