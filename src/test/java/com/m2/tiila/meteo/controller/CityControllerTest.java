package com.m2.tiila.meteo.controller;

import dto.weatherapi.City;
import jakarta.ws.rs.core.MediaType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CityControllerTest extends ControllerTest{
    @Test
    @DisplayName("test creation city")
    public void testCityController(){
        var city = new City();
        city.setName("Brest");
        city.setPosteCode(29200);
        city.setCountry("France");
        city.setId("3");
        given()
                .headers(headerMock())
                .contentType(MediaType.APPLICATION_JSON)
                .body(city)
                .post("/cities")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
