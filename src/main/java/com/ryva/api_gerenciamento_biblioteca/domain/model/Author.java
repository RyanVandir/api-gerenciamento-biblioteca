package com.ryva.api_gerenciamento_biblioteca.domain.model;

import com.ryva.api_gerenciamento_biblioteca.domain.exception.InvalidAuthorException;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Author {

    private Integer id;
    private String name;
    private String nationality;

    List<Book> books;

    public Author(Integer id, String name, String nationality, List<Book> books) {
        validate(name, nationality);
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.books = books != null ? books : new ArrayList<>();
    }

    public Author(String name, String nationality) {
        validate(name, nationality);
        this.name = name;
        this.nationality = nationality;
    }

    private void validate(String name, String nationality) {
        if (name == null || name.isBlank()) {
            throw new InvalidAuthorException("Nome do autor obrigatório");
        }
        if (name.trim().length() < 3) {
            throw new InvalidAuthorException("Autor deve conter no mínimo 3 caracteres");
        }
        if (nationality == null || nationality.isBlank()) {
            throw new InvalidAuthorException("Nacionalidade obrigatória");
        }
    }
}
