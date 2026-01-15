package com.ryva.api_gerenciamento_biblioteca.domain.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
}
