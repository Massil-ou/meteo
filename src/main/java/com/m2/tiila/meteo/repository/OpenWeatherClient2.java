package com.m2.tiila.meteo.repository;

import dto.openWeather.Model200;
import feign.Param;
import feign.RequestLine;

public interface OpenWeatherClient2 {

        @RequestLine("GET /data/2.5/weather?q={cityName}&appid={token}&units=metric")
        Model200 getWeather2(
                @Param("cityName") String cityName,
                @Param("token") String token
        );


}
