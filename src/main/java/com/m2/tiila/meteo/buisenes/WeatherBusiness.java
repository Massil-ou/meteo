package com.m2.tiila.meteo.buisenes;

import com.m2.tiila.meteo.entity.PrevisionEntity;
import com.m2.tiila.meteo.repository.WeatherRipository;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;

import static com.m2.tiila.meteo.mapper.WeatherMapper.toEntity;

@Component
public class WeatherBusiness {

    @Inject
    private WeatherRipository weatherRipository;
    public PrevisionEntity getCityWeather(String city){
        return  toEntity(weatherRipository.getCityWeather(city));
    }
}
