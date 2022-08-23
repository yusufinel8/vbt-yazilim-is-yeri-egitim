package com.springexercise.springexercise.exception.technical;

import com.springexercise.springexercise.exception.RestError;

public class TechnicalError extends RestError {
    private String message;

    private TechnicalError() {
        //For Jackson.
    }

    public TechnicalError(Exception exception) {
        super(exception);
        this.message = exception.getMessage();
    }

    public String getMessage() {
        return message;
    }

    @Override
    public TechnicalException getException() {
        return new TechnicalException(message);
    }
}
