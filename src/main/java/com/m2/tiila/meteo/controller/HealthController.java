package com.m2.tiila.meteo.controller;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.GET;

import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;

@Controller
@Path("/health")
public class HealthController {
    @GET
    public Response getHealth(){
        return Response.ok("yeah im fine").build();
    }
}
