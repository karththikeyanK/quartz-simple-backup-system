package com.eimsky.routingservice.controller;

import com.eimsky.routingservice.exceptions.*;
import com.eimsky.routingservice.response.ApiExceptionResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
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

    @ExceptionHandler(DuplicateContentException.class)
    public ResponseEntity<ApiExceptionResponse> handleDuplicateContentException(DuplicateContentException ex) {
        log.error("DuplicateContentException: "+ ex.getMessage());
        return ResponseEntity.badRequest().body(new ApiExceptionResponse(ApiExceptionResponse.ERROR,ex.getMessage()));
    }


    @ExceptionHandler(RecordCreationException.class)
    public ResponseEntity<ApiExceptionResponse> handleRecordCreationException(RecordCreationException ex) {
        log.error("RecordCreationException: "+ ex.getMessage());
        return ResponseEntity.badRequest().body(new ApiExceptionResponse(ApiExceptionResponse.ERROR,ex.getMessage()));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiExceptionResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        log.error("ResourceNotFoundException: "+ ex.getMessage());
        return ResponseEntity.badRequest().body(new ApiExceptionResponse(ApiExceptionResponse.ERROR,ex.getMessage()));
    }

    @ExceptionHandler(HttpStatusException.class)
    public ResponseEntity<ApiExceptionResponse> handleInvalidRequestException(HttpStatusException ex) {
        log.error("InvalidRequestException: "+ ex.getMessage());
        return ResponseEntity.badRequest().body(new ApiExceptionResponse(ApiExceptionResponse.ERROR,ex.getMessage()));
    }

    @ExceptionHandler(ResponseException.class)
    public ResponseEntity<ApiExceptionResponse> handleResponseException(ResponseException ex) {
        log.error("ResponseException: "+ ex.getMessage());
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

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<ApiExceptionResponse> handleJsonProcessingException(JsonProcessingException ex) {
        log.error("JsonProcessingException: "+ ex.getMessage());
        return ResponseEntity.badRequest().body(new ApiExceptionResponse(ApiExceptionResponse.ERROR,ex.getMessage()));
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<ApiExceptionResponse> handleIndexOutOfBoundsException(IndexOutOfBoundsException ex) {
        log.error("IndexOutOfBoundsException: "+ ex.getMessage());
        return ResponseEntity.badRequest().body(new ApiExceptionResponse(ApiExceptionResponse.ERROR,ex.getMessage()));
    }

    @ExceptionHandler(NullContainerException.class)
    public ResponseEntity<ApiExceptionResponse> handleNullContainerException(NullContainerException ex) {
        log.error("NullContainerException: "+ ex.getMessage());
        return ResponseEntity.badRequest().body(new ApiExceptionResponse(ApiExceptionResponse.ERROR,ex.getMessage()));
    }


}
