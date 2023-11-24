package com.m2.tiila.meteo.exception;

public class FunctionalException extends RuntimeException{

    private String code;

    public FunctionalException(String code,String description){
        super(description);
        this.code=code;
    }

    public String getCode() {
        return code;
    }





}
