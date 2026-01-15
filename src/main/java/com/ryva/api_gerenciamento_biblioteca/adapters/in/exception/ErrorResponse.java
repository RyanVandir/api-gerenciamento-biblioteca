package com.ryva.api_gerenciamento_biblioteca.adapters.in.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private String message;
    private Integer statusCode;
}
