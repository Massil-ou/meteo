package com.m2.tiila.meteo.mapper;

import com.m2.tiila.meteo.entity.CityEntitiy;
import dto.weatherapi.City;

public class mapper {

    public static City todto(CityEntitiy entitiy){
        City city=new City();
        city.setId(entitiy.getId());
        city.setName(entitiy.getNom());
        city.setPosteCode(entitiy.getCode());
        city.setRegion(entitiy.getRegion());
        city.setCountry(entitiy.getCountry());

        return city;
    }
    public static CityEntitiy toEntity(City city){
        CityEntitiy cityent=new CityEntitiy();
        cityent.setId(city.getId());
        cityent.setNom(city.getName());
        cityent.setCode(city.getPosteCode());
        cityent.setRegion(city.getRegion());
        cityent.setCountry(city.getCountry());

        return cityent;

    }
}
