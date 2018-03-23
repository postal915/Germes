package com.github.postal915.germes.app.infra.exception.flow;

import com.github.postal915.germes.app.infra.exception.FlowException;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * {@link ValidationException} is raised when attribute values of the object
 * model violates business rules or restrictions
 */
public class ValidationException extends FlowException {

    private static final long serialVersionUID = 6858621613562789296L;

    /**
     * List of constraints message keys
     */
    private final Set<ConstraintViolation<?>> constraints;

    public ValidationException(String message, Set<ConstraintViolation<?>> constraints) {
        super(message + constraints);
        this.constraints = constraints;
    }

    public Set<ConstraintViolation<?>> getConstraints() {
        return constraints;
    }
}
