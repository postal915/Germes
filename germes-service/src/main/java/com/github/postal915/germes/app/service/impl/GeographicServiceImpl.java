package com.github.postal915.germes.app.service.impl;

import com.github.postal915.germes.app.infra.util.CommonUtil;
import com.github.postal915.germes.app.model.entity.geography.City;
import com.github.postal915.germes.app.model.entity.geography.Station;
import com.github.postal915.germes.app.model.search.criteria.StationCriteria;
import com.github.postal915.germes.app.model.search.criteria.range.RangeCriteria;
import com.github.postal915.germes.app.persistence.repository.CityRepository;
import com.github.postal915.germes.app.persistence.repository.StationRepository;
import com.github.postal915.germes.app.persistence.repository.inmemory.InMemoryCityRepository;
import com.github.postal915.germes.app.service.GeographicService;

import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Default implementation of the {@link GeographicService}
 */

public class GeographicServiceImpl implements GeographicService {

    private final CityRepository cityRepository;

    private final StationRepository stationRepository;

    @Inject
    public GeographicServiceImpl(CityRepository cityRepository,
                                 StationRepository stationRepository) {
        this.cityRepository = cityRepository;
        this.stationRepository = stationRepository;
    }

    @Override
    public List<City> findCities() {
        System.out.println(cityRepository.findAll());
        return cityRepository.findAll();
    }

    @Override
    public void saveCity(City city) {
        cityRepository.save(city);
    }

    @Override
    public Optional<City> findCityById(final int id) {
        return Optional.ofNullable(cityRepository.findById(id));
    }

    @Override
    public List<Station> searchStations(final StationCriteria criteria, final RangeCriteria rangeCriteria) {
        return stationRepository.findAllByCriteria(criteria);
    }
}
