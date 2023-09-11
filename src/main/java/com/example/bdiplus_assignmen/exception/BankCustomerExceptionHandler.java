package com.example.bdiplus_assignmen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class BankCustomerExceptionHandler {

    @ExceptionHandler({DuplicateResourceException.class,ResourceNotFoundException.class})
    public ResponseEntity<String> handleException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodException(MethodArgumentNotValidException e){
        Map<String, String> error=new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(errorMap->error.put(errorMap.getField(),errorMap.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
