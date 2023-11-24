package com.m2.tiila.meteo.filtre;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;

@AuthenticationRequired
@Provider
public class AuthenticationRequiredFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        if(requestContext.getHeaders().get("authentication")==null){
            requestContext.abortWith(Response.status(403).build());

        }
    }
}
