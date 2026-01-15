package com.ryva.api_gerenciamento_biblioteca.port.out;

import com.ryva.api_gerenciamento_biblioteca.adapters.out.entity.BookEntity;
import com.ryva.api_gerenciamento_biblioteca.domain.model.Book;

import java.util.List;

public interface BookServicePort {

    Book createBook(Book book);

    List<Book> listBooks();

    Book updateBook(Integer id, Book book);
}
