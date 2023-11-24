package com.m2.tiila.meteo.repository.Interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OpenWeatherInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        //template.query("appid", "c6e381d5a3e3b2b1d2b0b2b0b2b0b2b0");
        template.header("from", "weather-api");
        log.info("Request to {}", template.url());
        log.info("1 2 3 going to weather api....");
    }
}
