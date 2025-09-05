package com.btsbooking.btsconcert.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity<>("❌ Error: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // You can catch other exceptions here too if needed
}
