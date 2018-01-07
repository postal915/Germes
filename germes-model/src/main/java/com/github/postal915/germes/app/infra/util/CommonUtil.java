package com.github.postal915.germes.app.infra.util;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

/**
 * Contains utility functions of the general purpose
 */

public class CommonUtil {

    private CommonUtil() {
    }

    /**
     * Returns not-null unmodifiable copy of the source set
     * @param sourse
     * @return
     */
    public static <T> Set<T> getSafeSet(Set<T> sourse) {
        return Collections.unmodifiableSet(Optional.ofNullable(sourse).orElse(Collections.emptySet()));
    }
}
