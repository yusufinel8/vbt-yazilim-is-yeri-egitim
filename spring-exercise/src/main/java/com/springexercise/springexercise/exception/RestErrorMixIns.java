package com.springexercise.springexercise.exception;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.springexercise.springexercise.exception.business.BusinessError;
import com.springexercise.springexercise.exception.notfound.NotFoundError;
import com.springexercise.springexercise.exception.technical.TechnicalError;

@JsonSubTypes({
        @JsonSubTypes.Type(value= BusinessError.class, name="BusinessError"),
        @JsonSubTypes.Type(value= TechnicalError.class, name="TechnicalError"),
        @JsonSubTypes.Type(value= NotFoundError.class, name="NotFoundError")
})
public interface RestErrorMixIns {
}
