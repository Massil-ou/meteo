package com.m2.tiila.meteo.controller;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class HealthControllerTest extends ControllerTest{

    @Test
    @DisplayName("test health")
    public void testHealthController(){
        given()
                .get("/health")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

}
