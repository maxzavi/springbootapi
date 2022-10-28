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

Create repository people, using https://swapi.dev/

```xml
    <!-- https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp -->
    <dependency>
      <groupId>com.squareup.okhttp3</groupId>
      <artifactId>okhttp</artifactId>
      <version>4.9.3</version>
    </dependency>
```

Sample Repository, implementation

Create entity starship

Add test

## Jdbctemplate
Create entity Product, repository ProductRepository, ProductRepositoryJdbc, add test

Create RepositoryTest, using H2 Database, and files creation and load data: 

- resources/jdbc/schema.sql
- resources/jdbc/test-data.sql

In H2
```sql
CREATE TABLE product(
   ID INT PRIMARY KEY,
   NAME VARCHAR(30), 
   price double,
   brandname VARCHAR2(25) );

insert into product(id, name, price,brandname) values (1,'Led Ultra HD',1899.0,'LG');
insert into product(id, name, price,brandname) values (2,'Test2',10.99,'Acme');
```

add beforeAll, non static method use annotation in class

```java
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
```

Equals for ProductControllerTest, using MockMvc autowired  use annotation in class:

```java
@AutoConfigureMockMvc
```



In Oracle:
```sql
CREATE TABLE product(
   ID INT PRIMARY KEY,
   NAME VARCHAR(30), 
   price number,
   brandname VARCHAR2(25) );

insert into product(id, name, price,brandname) values (1,'Led Ultra HD',1899.0,'LG');
insert into product(id, name, price,brandname) values (2,'Test2',10.99,'Acme');
```

Test with oracle using curl, postman or test.rest file, add in application.properties:

```properties
spring.datasource.url=jdbc:oracle:thin:@//{host}:{port}/{sid}
spring.datasource.username={username}
spring.datasource.password={password}
```

### Pagination

https://javabydeveloper.com/spring-jdbctemplate-pagination-examples/
