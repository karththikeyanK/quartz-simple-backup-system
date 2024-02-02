package com.example.quartz.controller;


import com.example.quartz.response.ApiExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerController {
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ApiExceptionResponse> handleDataAccessException(DataAccessException ex) {
        log.error("DataAccessException: "+ ex.getMessage());
        return ResponseEntity.badRequest().body(new ApiExceptionResponse(ApiExceptionResponse.ERROR,ex.getMessage()));
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiExceptionResponse> handleException(Exception ex) {
        log.error("Exception: "+ ex.getMessage());
        return ResponseEntity.badRequest().body(new ApiExceptionResponse(ApiExceptionResponse.ERROR,ex.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiExceptionResponse> handleRuntimeException(RuntimeException ex) {
        log.error("RuntimeException: "+ ex.getMessage());
        return ResponseEntity.badRequest().body(new ApiExceptionResponse(ApiExceptionResponse.ERROR,ex.getMessage()));
    }

    @ExceptionHandler(InterruptedException.class)
    public ResponseEntity<ApiExceptionResponse> handleInterruptedException(InterruptedException ex) {
        log.error("InterruptedException: "+ ex.getMessage());
        return ResponseEntity.badRequest().body(new ApiExceptionResponse(ApiExceptionResponse.ERROR,ex.getMessage()));
    }



}
