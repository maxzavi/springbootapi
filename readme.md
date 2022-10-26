# Spring Boot - Api Demo

Using DevTool, Web, Lombok

Add controllers

Use ResponseEntity in return

Add repository

## OpenAPIDefinition

Tutorial in https://www.youtube.com/watch?v=0vqgWQIVfMI

Add dependency maven

```xml
		<!-- https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-ui -->
		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-ui</artifactId>
			<version>1.6.9</version>
		</dependency>
```

view in http://localhost:8080/swagger-ui/index.html

In main class, use **OpenAPIDefinition** annotation

```java
@OpenAPIDefinition(info = @Info(title = "Price API", version = "1.0.0"))
public class MainApplication {
```

In RestController, use **Tag** annotation

```java
@Tag(name = "Price", description = "Price API")
```

## Api Client use *okhttp*

```xml
    <!-- https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp -->
    <dependency>
      <groupId>com.squareup.okhttp3</groupId>
      <artifactId>okhttp</artifactId>
      <version>4.9.3</version>
    </dependency>
```
