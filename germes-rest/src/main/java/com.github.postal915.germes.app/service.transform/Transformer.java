package com.github.postal915.germes.app.service.transform;

import com.github.postal915.germes.app.model.entity.base.AbstractEntity;
import com.github.postal915.germes.app.rest.dto.base.BaseDTO;

/**
 * Represent transformation engine to convert business entities
 * into DTO objects
 */
public interface Transformer {

    /**
     * Converts specified entity into DTO object
     *
     * @param entity
     * @param clz
     * @return
     */
    <T extends AbstractEntity, P extends BaseDTO<T>> P transform(T entity, Class<P> clz);

    /**
     * Converts specified DTO object into business entity
     *
     * @param dto
     * @param clz
     * @return
     */
    <T extends AbstractEntity, P extends BaseDTO<T>> T unTransform(P dto, Class<T> clz);

}