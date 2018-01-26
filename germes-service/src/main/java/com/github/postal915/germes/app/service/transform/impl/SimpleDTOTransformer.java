package com.github.postal915.germes.app.service.transform.impl;

import com.github.postal915.germes.app.infra.util.Checks;
import com.github.postal915.germes.app.infra.util.ReflectionUtil;
import com.github.postal915.germes.app.model.entity.base.AbstractEntity;
import com.github.postal915.germes.app.rest.dto.base.BaseDTO;
import com.github.postal915.germes.app.service.transform.Transformer;

/**
 * Default transformation engine that uses refection to transform objects
 */
public class SimpleDTOTransformer implements Transformer {

    @Override
    public <T extends AbstractEntity, P extends BaseDTO<T>> P transform(
            final T entity, final Class<P> clz) {
        checkParams(entity, clz);

        P dto = ReflectionUtil.createInstance(clz);
        // Now just copy all the similar fields
        ReflectionUtil.copyFields(entity, dto,
                ReflectionUtil.findSimilarFields(entity.getClass(), clz));
        dto.transform(entity);

        return dto;
    }

    private void checkParams(final Object param, final Class<?> clz) {

        Checks.checkParameter(param != null,
                "Source transformation object is not initialized");

        Checks.checkParameter(clz != null,
                "No class is defined for transformation");
    }

    @Override
    public <T extends AbstractEntity, P extends BaseDTO<T>> T unTransform(
            final P dto, final Class<T> clz) {
        checkParams(dto, clz);

        T entity = ReflectionUtil.createInstance(clz);

        ReflectionUtil.copyFields(dto, entity,
                ReflectionUtil.findSimilarFields(dto.getClass(), clz));
        dto.unTransform(entity);

        return entity;
    }
}
