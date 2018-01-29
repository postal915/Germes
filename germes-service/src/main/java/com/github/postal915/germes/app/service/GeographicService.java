package com.github.postal915.germes.app.service;

import com.github.postal915.germes.app.model.entity.geography.City;
import com.github.postal915.germes.app.model.entity.geography.Station;
import com.github.postal915.germes.app.model.search.criteria.StationCriteria;
import com.github.postal915.germes.app.model.search.criteria.range.RangeCriteria;

import java.util.List;
import java.util.Optional;

/**
 * Entity point to perform operations over geographic entities
 */

public interface GeographicService {

    /**
     * Returns list of existing cities
     *
     * @return
     */
    List<City> findCities();

    /**
     * Returns city with specified identified. If no city is found then empty optional is returned
     *
     * @param id
     * @return
     */
    Optional<City> findCityById(int id);

    /**
     * Returns all the stations that match specified criteria
     * @param criteria
     * @param rangeCriteria
     * @return
     */
    List<Station> searchStations(StationCriteria criteria, RangeCriteria rangeCriteria);

    /**
     * Saves specified city instance
     *
     * @param city
     */
    void saveCity(City city);
}
