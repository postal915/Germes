package com.github.postal915.germes.app.rest.service;

import com.github.postal915.germes.app.rest.service.config.JerseyConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;
import java.util.List;

import static org.junit.Assert.*;

/**
 * {@link CityResourceTest} is integration test that verifies
 * {@link CityResource}
 */

public class CityResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new JerseyConfig();
    }

    @Test
    public void testFindCitiesSuccess() {
        List<?> cities = target("cities").request().get(List.class);

        assertNotNull(cities);
        assertTrue(cities.contains("Odessa"));
        assertTrue(cities.contains("Kiev"));
    }
}