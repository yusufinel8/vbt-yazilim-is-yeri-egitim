package com.springexercise.springexercise.exception.business;

import com.springexercise.springexercise.exception.RestError;

public class BusinessError extends RestError {
    private String messageKey;
    private String[] arguments;

    private BusinessError() {
        // Needed for Jackson
    }

    public BusinessError(BusinessException exception) {
        this.messageKey = exception.getMessageKey();
        this.arguments = exception.getArgument();
    }

    public BusinessError(String messageKey) {
        this.messageKey = messageKey;
    }

    public BusinessError(String messageKey, String... arguments) {
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
    public BusinessException getException() {
        return new BusinessException(messageKey, arguments);
    }
}
