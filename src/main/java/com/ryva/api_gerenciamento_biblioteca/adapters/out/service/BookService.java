package com.ryva.api_gerenciamento_biblioteca.adapters.out.service;

import com.ryva.api_gerenciamento_biblioteca.adapters.mapper.BookMapper;
import com.ryva.api_gerenciamento_biblioteca.adapters.out.entity.BookEntity;
import com.ryva.api_gerenciamento_biblioteca.adapters.out.repository.BookRepository;
import com.ryva.api_gerenciamento_biblioteca.domain.exception.BookNotFoundException;
import com.ryva.api_gerenciamento_biblioteca.domain.model.Book;
import com.ryva.api_gerenciamento_biblioteca.port.out.BookServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService implements BookServicePort {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        return bookMapper.toModel(bookRepository.save(bookMapper.toEntity(book)));
    }

    @Override
    public List<Book> listBooks() {
        return bookMapper.toModel(bookRepository.findAll());
    }

    @Override
    public Book updateBook(Integer id, Book book) {
        BookEntity bookEntity = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Nenhum livro encontrado"));

        if (bookEntity.getTitle() != null) {
            bookEntity.setTitle(book.getTitle());
        }
        if (bookEntity.getYearPublished() != null) {
            bookEntity.setYearPublished(book.getYearPublished());
        }
        return bookMapper.toModel(bookRepository.save(bookEntity));
    }
}
