package com.ryva.api_gerenciamento_biblioteca.adapters.in.exception;

import com.ryva.api_gerenciamento_biblioteca.domain.exception.AuthorNotFoundException;
import com.ryva.api_gerenciamento_biblioteca.domain.exception.BookNotFoundException;
import com.ryva.api_gerenciamento_biblioteca.domain.exception.InvalidAuthorException;
import com.ryva.api_gerenciamento_biblioteca.domain.exception.InvalidBookException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({InvalidBookException.class, InvalidAuthorException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalid(RuntimeException e) {
        return new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler({AuthorNotFoundException.class, BookNotFoundException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFound(RuntimeException e) {
        return new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleInternalServerError(Exception e) {
        return new ErrorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
