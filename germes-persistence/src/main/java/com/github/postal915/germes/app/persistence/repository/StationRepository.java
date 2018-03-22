package com.github.postal915.germes.app.persistence.repository;

import com.github.postal915.germes.app.model.entity.geography.Station;
import com.github.postal915.germes.app.model.search.criteria.StationCriteria;

import java.util.List;

/**
 * Defines CRUD methods to access Station objects in the persistent storage
 */
public interface StationRepository {

    /**
     * Returns all the stations that match specified criteria
     *
     * @param stationCriteria
     * @return
     */
    List<Station> findAllByCriteria(StationCriteria stationCriteria);

}
