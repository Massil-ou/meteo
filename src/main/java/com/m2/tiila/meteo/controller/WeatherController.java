package com.m2.tiila.meteo.controller;

import com.m2.tiila.meteo.buisenes.WeatherBusiness;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

@Controller
@Path("/previsions")

public class WeatherController {

    @Inject
   private WeatherBusiness weatherBusiness;

    @Path("/{city}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response previsions(@PathParam("city") String city, @HeaderParam("role") String role){
    List<String> allowedCities = Arrays.asList("brest", "paris", "lille");

    if (role.equals("admin")) {
        return Response.ok(weatherBusiness.getCityWeather(city)).build();
    }
    else if ((role.equals("user") && allowedCities.contains(city))) {
        return Response.ok(weatherBusiness.getCityWeather(city)).build();
    } else {
        return Response.status(Response.Status.FORBIDDEN).entity("You are not allowed to access this city's weather.").build();
    }
    }
}
