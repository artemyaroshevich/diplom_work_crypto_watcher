package com.example.diplom_crypto_watcher.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ControllerAdvice
@Slf4j
public class ExController extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldError> fieldErrors = ex.getFieldErrors();
        Map<String, String> mapina = new HashMap<>();
        for (FieldError fieldError : fieldErrors) {
            mapina.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>(mapina, HttpStatus.BAD_REQUEST);
    }
}
