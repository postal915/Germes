package com.github.postal915.germes.app.service.impl;

import com.github.postal915.germes.app.model.entity.geography.City;
import com.github.postal915.germes.app.service.GeographicService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Contain unit-test for {@link GeographicServiceImpl}
 */

public class GeographicServiceImplTest {

    private GeographicService service;

    @Before
    public void setup() {
        service = new GeographicServiceImpl();
    }

    @Test
    public void testNoDataReturnedAtStart() {
        List<City> cities = service.findCities();

        assertTrue(cities.isEmpty());
    }

    @Test
    public void testSaveNewCitySuccess() {
        City city = new City("Odessa");
        service.saveCity(city);

        List<City> cities = service.findCities();

        assertEquals(cities.size(), 1);
        assertEquals(cities.get(0).getName(), "Odessa");
    }
}