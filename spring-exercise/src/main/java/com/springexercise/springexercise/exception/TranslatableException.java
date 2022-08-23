package com.springexercise.springexercise.exception;

public interface TranslatableException {

    String getMessageKey();

    String [] getArgument();
}
