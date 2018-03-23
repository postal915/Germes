package com.github.postal915.germes.app.model.transform;

/**
 * Any object that supports direct/back-ward transformation
 * into object kind of objects
 *
 * @param <P>
 */
public interface Transformable<P> {
    /**
     * Transforms given object into current one
     *
     * @param p
     */
    void transform(P p);

    /**
     * Transforms current object into given one
     *
     * @param p
     * @return
     */
    P unTransform(P p);

}