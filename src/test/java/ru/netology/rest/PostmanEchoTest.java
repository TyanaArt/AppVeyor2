package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    @Test
    void shouldReturnSenData() {
        given()
                .baseUri("https://postman-echo.com")
                .body("Data")
                .when()
                .post("/post")
                .then()
                .statusCode(Integer.parseInt("200"))
                .body("data", equalTo("data"))
                .body(matchesJsonSchemaInClasspath("postmanecho.schema.json"));


    }
}
