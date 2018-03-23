package org.germes.presentation.admin.bean;

import com.github.postal915.germes.app.model.entity.geography.City;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @link CityBean} is value holder of the city data for admin project
 */
@ManagedBean(name = "currentCity")
@ViewScoped
public class CityBean extends City {

}