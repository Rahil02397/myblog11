package com.myblog.moblog11.exception;

import com.myblog.moblog11.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
   @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(
            ResourceNotFoundException e,
            WebRequest webRequest
    ){
        ErrorDetails errorDetais = new ErrorDetails(e.getMessage(),new Date(),webRequest.getDescription(true));
        return  new ResponseEntity<>(errorDetais, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}