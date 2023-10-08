package com.retail.test.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice("com.retail.test")
public class ErrorHandler {

    @ExceptionHandler
    public ResponseEntity<Map<String, String>> handleBadRequestException(final BadRequestException e) {
        return new ResponseEntity<>(Map.of("Bad Request", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<Map<String, String>> handleNotFoundException(final NotFoundException e) {
        return new ResponseEntity<>(Map.of("NotFound Error", e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
