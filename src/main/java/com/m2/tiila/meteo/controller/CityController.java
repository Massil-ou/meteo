package com.m2.tiila.meteo.controller;

import com.m2.tiila.meteo.buisenes.CityBusiness;
import com.m2.tiila.meteo.filtre.AuthenticationRequired;
import dto.weatherapi.City;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;

import static com.m2.tiila.meteo.mapper.mapper.toEntity;

@Controller
@Path("/cities")
public class CityController {
    @Inject
    private CityBusiness cityBusiness;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @AuthenticationRequired
    public Response createCity(City city){
        this.cityBusiness.createCity(toEntity(city));
        return Response.ok().build();
    }

}
