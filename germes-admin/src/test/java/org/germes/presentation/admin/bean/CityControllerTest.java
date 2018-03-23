package org.germes.presentation.admin.bean;

import com.github.postal915.germes.app.model.entity.geography.City;
import com.github.postal915.germes.app.service.GeographicService;
import com.github.postal915.germes.app.service.transform.Transformer;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

/**
 * Verifies functionality of CityController
 * using Mockito for producing dependency mocks
 */
@RunWith(CdiRunner.class)
public class CityControllerTest {

    @Inject
    private CityController cityController;

    @Produces
    @Mock
    private GeographicService geographicService;

    @Produces
    @Mock
    private Transformer transformer;

    @Test
    public void saveCity_cityInitialized_citySuccessfullySaved() {
        CityBean cityBean = new CityBean();
        cityController.saveCity(cityBean);
        verify(geographicService, atLeastOnce()).saveCity(any(City.class));
    }

    @Test
    public void update_cityInitialized_cityBeanTransformed() {
        City city = new City();
        city.setId(1);
        city.setName("name");
        city.setDistrict("district");
        city.setRegion("region");
        CityBean cityBean = new CityBean();
        cityController.update(city, cityBean);
        verify(transformer, atLeastOnce()).transform(city, cityBean);
    }

}