package com.github.postal915.germes.app.service;

import com.github.postal915.germes.app.model.entity.geography.City;

import java.util.List;

/**
 * Entity point to perform operations
 * over geographic entities
 */

public interface GeographicService {

    /**
     * Returns list of existing cities
     */
    List<City> findCities();

    /**
     * Saves specified city instance
     *
     * @param city
     */
    void saveCity(City city);
}
