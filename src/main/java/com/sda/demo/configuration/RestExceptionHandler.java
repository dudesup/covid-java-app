package com.sda.demo.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice //class used to exception handling
public class RestExceptionHandler{

    @ExceptionHandler(value = UnsupportedOperationException.class)
    protected ResponseEntity <Object> handleConflict(RuntimeException ex, WebRequest request){
        RestError restError = new RestError();
        restError.setMessage("You cannont use this app");
        ResponseEntity<Object> objectResponseEntity = ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(restError);
        return objectResponseEntity;
    }

}
