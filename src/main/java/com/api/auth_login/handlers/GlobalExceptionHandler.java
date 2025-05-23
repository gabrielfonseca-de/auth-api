package com.api.auth_login.handlers;

import com.api.auth_login.dto.ErrorResponse;
import com.api.auth_login.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException ex) {
        ErrorResponse error = new ErrorResponse(ex.getStatus(), ex.getMessage());
        return new ResponseEntity<>(error, ex.getStatus());
    }
}
