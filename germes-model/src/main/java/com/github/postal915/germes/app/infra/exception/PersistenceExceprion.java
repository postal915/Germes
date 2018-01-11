package com.github.postal915.germes.app.infra.exception;

import com.github.postal915.germes.app.infra.exception.base.AppException;

/**
 * Signals about data access layer unexpected situations
 */

public class PersistenceExceprion extends AppException {

    public static final long serialVersionUID = -7889716045779735512L;

    public PersistenceExceprion(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistenceExceprion(String message) {
        super(message);
    }
}
