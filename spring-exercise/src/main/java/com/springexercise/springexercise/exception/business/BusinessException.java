package com.springexercise.springexercise.exception.business;

import com.springexercise.springexercise.exception.TranslatableException;

import java.util.Arrays;
import java.util.Objects;

public class BusinessException extends RuntimeException implements TranslatableException {
    private String messageKey;
    private String[] arguments;

    private BusinessException() {
    }

    public BusinessException(String messageKey, Throwable throwable, String... arguments) {
        super(messageKey, throwable);
        this.messageKey = messageKey;
        this.arguments = arguments == null ? new String[0] : arguments;
    }

    public BusinessException(String messageKey, String... arguments) {
        super(messageKey);
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


    public boolean hasMessageKey(String messageKey) {
        return Objects.equals(this.messageKey, messageKey);
    }

    public String toString() {
        return super.toString() + ", arguments=" + Arrays.toString(this.arguments);
    }

    public static BusinessException forMessageKey(String messageKey) {
        return new BusinessException(messageKey, new String[0]);
    }

    public static BusinessException forMessageKey(String messageKey, Throwable throwable) {
        return new BusinessException(messageKey, throwable, new String[0]);
    }

    public static BusinessException forMessageKey(String messageKey, String... arguments) {
        return new BusinessException(messageKey, arguments);
    }

    public static BusinessException forMessageKey(String messageKey, Throwable throwable, String... arguments) {
        return new BusinessException(messageKey, throwable, arguments);
    }
}