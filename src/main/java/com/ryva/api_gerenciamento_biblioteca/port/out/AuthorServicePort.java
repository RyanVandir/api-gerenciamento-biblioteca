package com.ryva.api_gerenciamento_biblioteca.port.out;

import com.ryva.api_gerenciamento_biblioteca.domain.model.Author;

import java.util.List;

public interface AuthorServicePort {

    boolean existById(Integer id);

    Author createAuthor(Author author);

    List<Author> listAuthors();

    Author deleteAuthor(Integer id);

    Author findById(Integer id);

}
