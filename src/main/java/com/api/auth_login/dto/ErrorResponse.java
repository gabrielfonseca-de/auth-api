package com.api.auth_login.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private final int statusCode;
    private final String message;
    private final LocalDateTime timestamp;

    public ErrorResponse(HttpStatus status, String message) {
        this.statusCode = status.value();
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}
