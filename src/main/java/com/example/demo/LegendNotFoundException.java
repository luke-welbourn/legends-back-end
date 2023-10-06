package com.example.demo;

import org.springframework.http.HttpStatus;

public class LegendNotFoundException extends RuntimeException {
    private HttpStatus code = HttpStatus.NOT_FOUND;

    public LegendNotFoundException(String message) {
        super(message);
    }

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }
}
