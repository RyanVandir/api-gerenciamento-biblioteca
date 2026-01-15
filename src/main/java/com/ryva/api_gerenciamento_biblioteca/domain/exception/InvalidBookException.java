package com.ryva.api_gerenciamento_biblioteca.domain.exception;

public class InvalidBookException extends RuntimeException {
    public InvalidBookException(String message) {
        super(message);
    }
}
