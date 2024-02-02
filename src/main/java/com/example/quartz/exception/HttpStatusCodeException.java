package com.example.quartz.exception;

public class HttpStatusCodeException extends RuntimeException{
    public HttpStatusCodeException(String message) {
        super(message);
    }
}
