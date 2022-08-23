package com.springexercise.springexercise.exception.notfound;

import com.springexercise.springexercise.exception.RestError;

public class NotFoundError extends RestError {
    private String messageKey;
    private String[] arguments;

    private NotFoundError() {
        //Needed for Jackson.
    }

    public NotFoundError(String messageKey, String... arguments) {
        this.messageKey = messageKey;
        this.arguments = arguments;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public String[] getArguments() {
        return arguments;
    }

    @Override
    public ResourceNotFoundException getException() {
        return new ResourceNotFoundException(messageKey, arguments);
    }
}

