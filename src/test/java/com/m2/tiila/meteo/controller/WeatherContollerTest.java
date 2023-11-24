package com.m2.tiila.meteo.controller;

import com.m2.tiila.meteo.repository.client.OpenWeatherClient;
import dto.openWeather.Main;
import dto.openWeather.Model200;
import jakarta.inject.Inject;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static io.restassured.RestAssured.given;
import static org.mockito.Mockito.when;

import static org.mockito.ArgumentMatchers.any;

public class WeatherContollerTest extends ControllerTest{
    @Inject
    private OpenWeatherClient openWeatherClient;

    @Test
    @DisplayName("test")
    public void testPrevission(){
        var model200 = new Model200();
        var main = new Main();
        main.setTemp(new BigDecimal(40));
        model200.setMain(main);
        model200.setName("Brest");

        when(openWeatherClient.getWeather(any(), any())).thenReturn(model200);
        given()
                .headers(headerMock2())
                .get("/prevision/Brest")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
