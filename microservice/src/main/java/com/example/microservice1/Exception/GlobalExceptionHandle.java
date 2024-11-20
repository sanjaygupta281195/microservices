package com.example.microservice1.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorDetails> resourceNotFound(ResourceNotFound ex, WebRequest request){
        ErrorDetails error = new ErrorDetails(ex.getMessage(),"404",new Date());
        return new ResponseEntity<ErrorDetails>(error, HttpStatus.NOT_FOUND);
    }
}
