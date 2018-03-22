package org.germes.presentation.admin.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Managed bean that keeps all the cities for the main page
 */
@Named
@RequestScoped
public class CitiesBean {

    private final List<CityBean> cities;

    public CitiesBean() {
        cities = new ArrayList<>();
        cities.add(new CityBean("Odessa", "", "Odessa"));
        cities.add(new CityBean("Izmail", "", "Odessa"));
    }

    public List<CityBean> getCities() {
        return cities;
    }
}