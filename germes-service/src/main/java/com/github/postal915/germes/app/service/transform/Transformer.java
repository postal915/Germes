package com.github.postal915.germes.app.service.transform;

import com.github.postal915.germes.app.model.entity.base.AbstractEntity;
import com.github.postal915.germes.app.model.transform.Transformable;

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
     * @param <T>
     * @param <P>
     * @return
     */
    <T extends AbstractEntity, P extends Transformable<T>> P transform(T entity, Class<P> clz);

    /**
     * Converts specified entity into existing DTO object
     *
     * @param entity
     * @param dest
     * @param <T>
     * @param <P>
     */
    <T extends AbstractEntity, P extends Transformable<T>> void transform(T entity, P dest);

    /**
     * Converts specified DTO object into business entity
     *
     * @param dto
     * @param clz
     * @param <T>
     * @param <P>
     * @return
     */
    <T extends AbstractEntity, P extends Transformable<T>> T unTransform(P dto, Class<T> clz);

}