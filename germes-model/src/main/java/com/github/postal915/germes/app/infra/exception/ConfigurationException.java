package com.github.postal915.germes.app.infra.exception;

import com.github.postal915.germes.app.infra.exception.base.AppException;

/**
 * Signals about incorrect configuration settings/parameters
 */

public class ConfigurationException extends AppException {

    public static final long serialVersionUID = -2177284893894040026L;

    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigurationException(String message) {
        super(message);
    }

    public ConfigurationException(Throwable throwable) {
        super(throwable);
    }

}
