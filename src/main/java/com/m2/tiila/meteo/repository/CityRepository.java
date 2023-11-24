package com.m2.tiila.meteo.repository;

import com.m2.tiila.meteo.entity.CityEntitiy;
import dto.weatherapi.City;
import jakarta.inject.Inject;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Component
public class CityRepository {

    private final static String SQL_Insert= "INSERT INTO City (id, nom, code, region,country) VALUES (:id,:nom,'123',:region,:country)";
    @Inject
    private NamedParameterJdbcTemplate jdbcTemplate;
    public void createcity(City city){
        var params= new HashMap<String,String>();
        params.put("id",city.getId());
        params.put("nom",city.getName());
        //params.put("code", Optional.ofNullable(city.getPosteCode()).map(x -> x.toString()).orElse(""));
        params.put("region",city.getRegion());
        params.put("country",city.getCountry());
        this.jdbcTemplate.update(SQL_Insert,params);
    }




}
