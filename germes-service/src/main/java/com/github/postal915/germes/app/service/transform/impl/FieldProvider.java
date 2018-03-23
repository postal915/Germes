package com.github.postal915.germes.app.service.transform.impl;

import com.github.postal915.germes.app.infra.util.ReflectionUtil;

import java.util.List;

/**
 * Base functionality of the field preparation
 */
public class FieldProvider {

    public List<String> getFieldNames(Class<?> source, Class<?> dest) {
        return ReflectionUtil.findSimilarFields(source, dest);
    }
}