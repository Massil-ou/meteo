package com.m2.tiila.meteo.configuration;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ApplicationPath("/api/v1")
@Primary

public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(){
        packages("com.m2.tiila.meteo.controller");
        packages("com.m2.tiila.meteo.filtre");
        packages("com.m2.tiila.meteo.exception");
    }

}
