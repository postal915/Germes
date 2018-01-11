package com.github.postal915.germes.app.infra.exception;

import com.github.postal915.germes.app.infra.exception.base.AppException;

/**
 * Signals about exception cases int the work of external services and API
 */

public class CommunicationExeption extends AppException {

    public static final long serialVersionUID = -2850898723336164866L;

    public CommunicationExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public CommunicationExeption(String message) {
        super(message);
    }
}
