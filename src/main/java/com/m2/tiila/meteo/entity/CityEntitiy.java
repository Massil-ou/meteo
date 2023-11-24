package com.m2.tiila.meteo.entity;

import lombok.Data;

@Data
public class CityEntitiy {
    public String id;
    public String nom;
    public Integer code;
    public String region;
    public String country;
}
