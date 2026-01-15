package com.ryva.api_gerenciamento_biblioteca.port.in;

import com.ryva.api_gerenciamento_biblioteca.domain.model.Author;

import java.util.List;

public interface AuthorUseCasePort {

    Author createAuthor(Author author);
    List<Author> listAuthors();
    Author deleteAuthor(Integer id);
}
