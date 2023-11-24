package com.m2.tiila.meteo.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2.tiila.meteo.repository.Interceptor.OpenWeatherInterceptor;
import com.m2.tiila.meteo.repository.client.OpenWeatherClient;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import jakarta.inject.Inject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.concurrent.TimeUnit;

@Configuration
@Profile("!TEST")
public class FeignConfig {

    @Inject
    private ObjectMapper objectMapper;
    @Inject
    private OpenWeatherInterceptor interceptor;

    @Bean
    OpenWeatherClient getOpenWeatherFeign(){
       return Feign.builder()
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper))
                .client(new OkHttpClient(getOkHttpClient()))
                .requestInterceptor(interceptor)
                .logger(new Logger.JavaLogger(FeignConfig.class))
                .logLevel(Logger.Level.FULL)
                .target(OpenWeatherClient.class, "https://api.openweathermap.org/");
    }
    private okhttp3.OkHttpClient getOkHttpClient() {
        var okhttpclient = new okhttp3.OkHttpClient().newBuilder();
        okhttpclient.connectTimeout(1000, TimeUnit.MICROSECONDS);
        okhttpclient.readTimeout(1000, TimeUnit.MICROSECONDS);
        return okhttpclient.build();
    }

}
