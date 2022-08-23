package com.springexercise.springexercise.exception.notfound;

import com.springexercise.springexercise.exception.TranslatableException;

import java.util.Arrays;
import java.util.Objects;

public class ResourceNotFoundException extends RuntimeException implements TranslatableException {
    private String messageKey;
    private String[] arguments;

    private ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String messageKey, String... arguments) {
        this.messageKey = messageKey;
        this.arguments = arguments == null ? new String[0] : arguments;
    }

    public String getMessageKey() {
        return this.messageKey;
    }

    @Override
    public String[] getArgument() {
        return this.arguments;
    }

    public String[] getArguments() {
        return this.arguments;
    }

    public boolean hasMessageKey(String messageKey) {
        return Objects.equals(this.messageKey, messageKey);
    }

    public String toString() {
        return super.toString() + ", arguments=" + Arrays.toString(this.arguments);
    }

    public static ResourceNotFoundException forMessageKey(String messageKey) {
        return new ResourceNotFoundException(messageKey, new String[0]);
    }

    public static ResourceNotFoundException forMessageKey(String messageKey, String... arguments) {
        return new ResourceNotFoundException(messageKey, arguments);
    }
}
