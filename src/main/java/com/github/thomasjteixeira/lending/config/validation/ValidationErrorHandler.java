package com.github.thomasjteixeira.lending.config.validation;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationErrorHandling {

    @ExceptionHandler
    public void handle(){

    }
}
