package com.github.postal915.germes.app.service.impl;

import com.github.postal915.germes.app.infra.util.CommonUtil;
import com.github.postal915.germes.app.model.entity.geography.City;
import com.github.postal915.germes.app.model.entity.geography.Station;
import com.github.postal915.germes.app.model.search.criteria.StationCriteria;
import com.github.postal915.germes.app.model.search.criteria.range.RangeCriteria;
import com.github.postal915.germes.app.service.GeographicService;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Default implementation of the {@link GeographicService}
 */

public class GeographicServiceImpl implements GeographicService {

    /**
     * Internal list of cities
     */
    private final List<City> cities;

    /**
     * Auto-increment counter for entity id generation
     */
    private int counter = 0;

    public GeographicServiceImpl() {
        cities = new ArrayList<City>();
    }

    @Override
    public List<City> findCities() {
        return CommonUtil.getSafeList(cities);
    }

    @Override
    public void saveCity(City city) {
        if (!cities.contains(city)) {
            city.setId(++counter);
            cities.add(city);
        }
    }

    @Override
    public Optional<City> findCityById(final int id) {
        return cities.stream().filter(city -> city.getId() == id).findFirst();
    }

    @Override
    public List<Station> searchStations(final StationCriteria criteria, final RangeCriteria rangeCriteria) {
        Stream<City> stream = cities.stream().filter(
                city -> StringUtils.isEmpty(criteria.getName()) || city.getName().equals(criteria.getName()));

        Optional<Set<Station>> stations = stream.map(city -> city.getStations()).reduce((stations1, stations2) -> {
            Set<Station> newStations = new HashSet<>(stations2);
            newStations.addAll(stations1);
            return newStations;
        });

        if (!stations.isPresent()) {
            return Collections.emptyList();
        }

        return stations.get()
                .stream()
                .filter(station -> criteria.getTransportType() == null ||
                        station.getTransportType() == criteria.getTransportType()).collect(Collectors.toList());
    }
}
