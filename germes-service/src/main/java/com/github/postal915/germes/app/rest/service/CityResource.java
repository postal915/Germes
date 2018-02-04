package com.github.postal915.germes.app.rest.service;

import com.github.postal915.germes.app.model.entity.geography.City;
import com.github.postal915.germes.app.model.entity.transport.TransportType;
import com.github.postal915.germes.app.rest.dto.CityDTO;
import com.github.postal915.germes.app.rest.service.base.BaseResource;
import com.github.postal915.germes.app.service.GeographicService;
import com.github.postal915.germes.app.service.transform.Transformer;
import org.apache.commons.lang3.math.NumberUtils;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * {@link CityResource} is REST web-service that handles city-related requests
 */
@Path("cities")
public class CityResource extends BaseResource {

    /**
     * Underlying source of data
     */
    private final GeographicService service;

    /**
     * DTO <-> Entity transformer
     */
    private final Transformer transformer;

    @Inject
    public CityResource(GeographicService service, Transformer transformer) {
        this.transformer = transformer;
        this.service = service;
        City city = new City("Odessa");
        city.addStation(TransportType.AUTO);
        service.saveCity(city);
    }

    /**
     * Returns all the existing cities
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CityDTO> findCities() {
        return service.findCities().stream().map(city -> transformer.transform(city, CityDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Saves new city instance
     *
     * @param cityDTO
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveCity(CityDTO cityDTO) {
        service.saveCity(transformer.unTransform(cityDTO, City.class));
    }

    /**
     * Returns city with specified identifier
     *
     * @param cityId
     * @return
     */
    @Path("/{cityId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCityById(@PathParam("cityId") final String cityId) {
        if (!NumberUtils.isNumber(cityId)) {
            return BAD_REQUEST;
        }

        Optional<City> city = service.findCityById(NumberUtils.toInt(cityId));

        if (!city.isPresent()) {
            return NOT_FOUND;
        }

        return ok(transformer.transform(city.get(), CityDTO.class));
    }
}
