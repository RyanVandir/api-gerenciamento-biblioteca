package com.ryva.api_gerenciamento_biblioteca.domain.exception;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(String message) {
        super(message);
    }
}
