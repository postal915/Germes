package com.github.postal915.germes.app.infra.exception.flow;


import com.github.postal915.germes.app.infra.exception.FlowException;

/**
 * Signals that incorrect parameter was passed to method/constructor
 */

public class InvalidParameterException extends FlowException {

    public static final long serialVersionUID = 4990959228756992926L;

    public InvalidParameterException(String message) {
        super(message);
    }
}
