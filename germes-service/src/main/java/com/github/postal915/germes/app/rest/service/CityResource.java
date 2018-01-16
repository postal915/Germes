package com.github.postal915.germes.app.rest.service;

import com.google.common.collect.Lists;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("cities")
/**
 * {@link CityResource} is REST web-service that handles city-related requests
 */
public class CityResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> findCities() {
        return Lists.newArrayList("Odessa", "Kiev");
    }
}
