package com.sky.pro.employeeservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class UnexpectedCharacterException extends RuntimeException {
    public UnexpectedCharacterException(String message) {
        super(message);
    }

    public UnexpectedCharacterException(String message, Throwable cause) {
        super(message, cause);
    }
}
