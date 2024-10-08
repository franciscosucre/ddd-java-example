package com.smes.smes.adapters.in.exception_handlers;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();

        List<Map<String, Object>> errorMaps = new ArrayList<>();
        for (FieldError error : errors) {
            Map<String, Object> map = new HashMap<>();
            map.put("field", error.getField());
            map.put("message", error.getDefaultMessage());
            errorMaps.add(map);
        }

        Map<String, Object> response = new HashMap<String, Object>();
        response.put("status", HttpStatus.UNPROCESSABLE_ENTITY.value());
        response.put("message", "Validation failed");
        response.put("errors", errorMaps);

        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY);
    }


}