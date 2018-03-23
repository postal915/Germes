package com.github.postal915.germes.app.service.transform.impl;

import com.github.postal915.germes.app.infra.exception.flow.InvalidParameterException;
import com.github.postal915.germes.app.model.entity.geography.City;
import com.github.postal915.germes.app.rest.dto.CityDTO;
import com.github.postal915.germes.app.service.transform.Transformer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Verifies functionality of the {@link SimpleDTOTransformer} unit
 */
public class SimpleDTOTransformerTest {

    private Transformer transformer;

    @Before
    public void setup() {
        transformer = new SimpleDTOTransformer();
    }

    @Test
    public void testTransformCitySuccess() throws Exception {
        City city = new City("Odessa");
        city.setId(1);
        city.setRegion("Od");
        city.setDistrict("None");

        CityDTO dto = transformer.transform(city, CityDTO.class);

        assertNotNull(dto);
        assertEquals(dto.getId(), city.getId());
        assertEquals(dto.getName(), city.getName());
        assertEquals(dto.getDistrict(), city.getDistrict());
        assertEquals(dto.getRegion(), city.getRegion());
    }

    @Test(expected = InvalidParameterException.class)
    public void testTransformNullCityFailure() {
        transformer.transform(null, CityDTO.class);
    }

    @Test(expected=InvalidParameterException.class)
    public void testTransformNullDTOClassFailure() {
        transformer.transform(new City("Odessa"), (Class<CityDTO>)null);
    }

    @Test
    public void testUnTransformCitySuccess() {
        CityDTO dto = new CityDTO();
        dto.setId(1);
        dto.setRegion("Od");
        dto.setDistrict("None");
        dto.setName("Odessa");

        City city = transformer.unTransform(dto, City.class);
        assertNotNull(city);
        assertEquals(dto.getId(), city.getId());
        assertEquals(dto.getName(), city.getName());
        assertEquals(dto.getDistrict(), city.getDistrict());
        assertEquals(dto.getRegion(), city.getRegion());
    }

    @Test(expected = InvalidParameterException.class)
    public void testUnTransformNullCityFailure() {
        transformer.unTransform(null, City.class);
    }

    @Test(expected = InvalidParameterException.class)
    public void testUnTransformNullEntityClassFailure() {
        transformer.unTransform(new CityDTO(), null);
    }
}