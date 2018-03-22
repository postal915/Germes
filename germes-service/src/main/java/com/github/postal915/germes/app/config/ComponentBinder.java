package com.github.postal915.germes.app.config;

import javax.inject.Singleton;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import com.github.postal915.germes.app.persistence.hibernate.SessionFactoryBuilder;
import com.github.postal915.germes.app.persistence.repository.CityRepository;
import com.github.postal915.germes.app.persistence.repository.StationRepository;
import com.github.postal915.germes.app.persistence.repository.hibernate.HibernateCityRepository;
import com.github.postal915.germes.app.persistence.repository.hibernate.HibernateStationRepository;
import com.github.postal915.germes.app.service.GeographicService;
import com.github.postal915.germes.app.service.impl.GeographicServiceImpl;
import com.github.postal915.germes.app.service.transform.Transformer;
import com.github.postal915.germes.app.service.transform.impl.SimpleDTOTransformer;

import javax.inject.Singleton;

/**
 * Binds bean implementations and implemented interfaces
 */
public class ComponentBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(HibernateCityRepository.class).to(CityRepository.class).in(Singleton.class);
        bind(HibernateStationRepository.class).to(StationRepository.class).in(Singleton.class);
        bind(SimpleDTOTransformer.class).to(Transformer.class).in(Singleton.class);
        bind(GeographicServiceImpl.class).to(GeographicService.class).in(Singleton.class);
        bind(SessionFactoryBuilder.class).to(SessionFactoryBuilder.class).in(Singleton.class);
    }
}
