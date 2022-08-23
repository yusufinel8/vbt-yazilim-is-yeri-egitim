package com.springexercise.springexercise.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springexercise.springexercise.exception.business.BusinessError;
import com.springexercise.springexercise.exception.business.BusinessException;
import com.springexercise.springexercise.exception.notfound.NotFoundError;
import com.springexercise.springexercise.exception.notfound.ResourceNotFoundException;
import com.springexercise.springexercise.exception.technical.TechnicalError;
import com.springexercise.springexercise.exception.technical.TechnicalException;
import io.micrometer.core.instrument.util.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.io.InputStream;

@ControllerAdvice
public class HandlerAllException  implements ResponseErrorHandler {


    ResponseErrorHandler responseErrorHandler= new DefaultResponseErrorHandler();

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return responseErrorHandler.hasError(response);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {

        InputStream body =response.getBody();

        if(body!=null){

            String bodyAsString= IOUtils.toString(body);
            ObjectMapper objectMapper=new ObjectMapper();
            RestError error=objectMapper.readValue(bodyAsString,RestError.class);
            throw error.getException();
        }
        responseErrorHandler.handleError(response);
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<Object> BusinessException(final BusinessException exception) {

        return new ResponseEntity<>(new BusinessError(exception), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<NotFoundError> resourceNotFound(final ResourceNotFoundException exception) {
        return new ResponseEntity<>(
                new NotFoundError(exception.getMessageKey(), exception.getArguments()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TechnicalException.class)
    public ResponseEntity<TechnicalError> technicalError(final TechnicalException exception) {
        return new ResponseEntity<>(new TechnicalError(exception), HttpStatus.INTERNAL_SERVER_ERROR);
    }




}
