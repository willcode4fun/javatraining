package com.valtech.talent.program.web;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandlerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value= { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict( RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Error while performing action";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}