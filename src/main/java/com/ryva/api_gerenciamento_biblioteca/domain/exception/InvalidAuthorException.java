package com.ryva.api_gerenciamento_biblioteca.domain.exception;

public class InvalidAuthorException extends RuntimeException {
    public InvalidAuthorException(String message) {
        super(message);
    }
}
