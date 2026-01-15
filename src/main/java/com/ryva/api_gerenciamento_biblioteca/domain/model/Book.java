package com.ryva.api_gerenciamento_biblioteca.domain.model;

import com.ryva.api_gerenciamento_biblioteca.domain.exception.InvalidAuthorException;
import com.ryva.api_gerenciamento_biblioteca.domain.exception.InvalidBookException;
import lombok.Getter;
import lombok.ToString;

import java.time.Year;

@Getter
@ToString
public class Book {

    Integer id;
    String title;
    Integer yearPublished;
    Integer authorId;

    public Book(Integer id, String title, Integer yearPublished,  Integer authorId) {
        validate(title, yearPublished, authorId);
        this.id = id;
        this.title = title;
        this.yearPublished = yearPublished;
        this.authorId = authorId;
    }

    public Book(String title, Integer yearPublished,  Integer authorId) {
        validate(title, yearPublished,authorId);
        this.title = title;
        this.yearPublished = yearPublished;
        this.authorId = authorId;
    }

    public void validate(String title, Integer yearPublished, Integer authorId) {
        if (title == null || title.isBlank()) {
            throw new InvalidBookException("Título obrigatório");
        }

        int currentYear = Year.now().getValue();
        if (yearPublished == null || yearPublished > currentYear) {
            throw new InvalidBookException("Ano de publicação inválido");
        }

        if (authorId == null) {
            throw new InvalidAuthorException("Autor é obrigatório");
        }
    }
}
