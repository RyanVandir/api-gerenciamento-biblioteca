package com.ryva.api_gerenciamento_biblioteca.port.in;

import com.ryva.api_gerenciamento_biblioteca.domain.model.Book;

import java.util.List;

public interface BookUseCasePort {

    Book createdBook(Book book);
    List<Book> listBooks();
    Book updateBook(Integer id,Book book);
}
