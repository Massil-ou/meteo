package com.m2.tiila.meteo.configuration;

import com.m2.tiila.meteo.repository.client.OpenWeatherClient;
import jakarta.inject.Inject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static org.mockito.Mockito.mock;


@Configuration
@Profile("TEST")
public class FeignConfigMock {

    @Bean
    public OpenWeatherClient getOpenWeatherFeign(){
        return mock(OpenWeatherClient.class);
    }

}
