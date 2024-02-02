package com.example.quartz.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiExceptionResponse {
    public static final String WARNING = "WARNING";
    public static final String ERROR = "ERROR";

    private String status;
    private String msg;
}
