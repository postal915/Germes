package org.germes.presentation.admin.bean;

import com.github.postal915.germes.app.model.entity.geography.City;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * Verifies functionality of CityBean class
 */
public class CityBeanTest {

    @Test
    public void clear_beanInitialized_allFieldsCleared() {
        CityBean cityBean = new CityBean();
        cityBean.setDistrict("test");
        cityBean.setId(1);
        cityBean.setName("test");
        cityBean.setRegion("test");
        cityBean.clear();
        assertTrue(StringUtils.isEmpty(cityBean.getDistrict()));
        assertTrue(StringUtils.isEmpty(cityBean.getName()));
        assertTrue(StringUtils.isEmpty(cityBean.getRegion()));
        assertTrue(cityBean.getId() == 0);
    }

    @Test
    public void unTransform_cityInitialized_cityReturned() {
        City city = new City();
        CityBean cityBean = new CityBean();
        City newCity = cityBean.unTransform(city);
        assertSame(city, newCity);
    }

}