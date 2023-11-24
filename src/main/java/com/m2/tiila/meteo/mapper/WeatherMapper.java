package com.m2.tiila.meteo.mapper;

import com.m2.tiila.meteo.entity.PrevisionEntity;
import com.m2.tiila.meteo.entity.WeatherState;
import dto.openWeather.Model200;
import dto.weatherapi.Prevision;

import java.time.Instant;
import java.time.LocalDate;

public class WeatherMapper {

    public static PrevisionEntity toEntity(Model200 dto){
        PrevisionEntity previsionEntity = new PrevisionEntity();

        previsionEntity.setCity(dto.getName());
        previsionEntity.setState(mapToWeatherState(dto.getWeather().get(0).getMain()));
        previsionEntity.setTemperature(dto.getMain().getTemp().floatValue());
        previsionEntity.setDate(Instant.ofEpochSecond(dto.getDt()));

        return previsionEntity;
    }
    public static Prevision toDto(PrevisionEntity entity){
        Prevision prevision = new Prevision();

        prevision.setDate(LocalDate.from(entity.getDate()));
        prevision.setTemperature((int) entity.getTemperature());
        prevision.setCity(entity.getCity());
        prevision.setState(mapToExternal(entity.getState()));

        return prevision;
    }
    public static dto.weatherapi.WeatherState mapToExternal(WeatherState internalWeatherState) {
        switch (internalWeatherState) {
            case Nuageux:
                return dto.weatherapi.WeatherState.NUAGEUX;
            case Pluvieux:
                return dto.weatherapi.WeatherState.PLUVIEUX;
            case Niegeux:
                return dto.weatherapi.WeatherState.NEIGEUX;
            case Venteux:
                return dto.weatherapi.WeatherState.VENTEUX;
            case Ensoleille:
                return dto.weatherapi.WeatherState.ENSOLEILLE;
            default:
                return dto.weatherapi.WeatherState.NUAGEUX;        }
    }
    public static WeatherState mapToWeatherState(String weatherString) {
        String normalizedWeatherString = weatherString.toUpperCase();

        switch (normalizedWeatherString) {
            case "CLOUDS":
                return WeatherState.Nuageux;
            case "RAIN":
                return WeatherState.Pluvieux;
            case "SNOW":
                return WeatherState.Niegeux;
            case "WIND":
                return WeatherState.Venteux;
            case "CLEAR":
                return WeatherState.Ensoleille;
            default:
                return WeatherState.Nuageux;
        }
    }

    public static WeatherState mapToInternal(dto.weatherapi.WeatherState externalWeatherState) {
        switch (externalWeatherState) {
            case NUAGEUX:
                return WeatherState.Nuageux;
            case PLUVIEUX:
                return WeatherState.Pluvieux;
            case NEIGEUX:
                return WeatherState.Niegeux;
            case VENTEUX:
                return WeatherState.Venteux;
            case ENSOLEILLE:
                return WeatherState.Ensoleille;
            default:
                throw new IllegalArgumentException("Conversion non gérée pour WeatherState: " + externalWeatherState);
        }
    }
}
