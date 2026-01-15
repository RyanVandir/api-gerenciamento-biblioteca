package com.ryva.api_gerenciamento_biblioteca.usecase;

import com.ryva.api_gerenciamento_biblioteca.domain.exception.AuthorNotFoundException;
import com.ryva.api_gerenciamento_biblioteca.domain.exception.BookNotFoundException;
import com.ryva.api_gerenciamento_biblioteca.domain.model.Book;
import com.ryva.api_gerenciamento_biblioteca.port.in.BookUseCasePort;
import com.ryva.api_gerenciamento_biblioteca.port.out.AuthorServicePort;
import com.ryva.api_gerenciamento_biblioteca.port.out.BookServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookUseCase implements BookUseCasePort {

    private final BookServicePort bookService;
    private final AuthorServicePort authorService;


    @Override
    public Book createdBook(Book book) {
        if (!authorService.existById(book.getAuthorId())){
            throw new AuthorNotFoundException("Nenhum autor encontrado");
        }
        return bookService.createBook(book);
    }

    @Override
    public List<Book> listBooks() {
        List<Book> books = bookService.listBooks();
        if (books.isEmpty()) {
            throw new BookNotFoundException("Nenhum livro encontrado");
        }
        return books;
    }

    @Override
    public Book updateBook(Integer id, Book book) {
        return  bookService.updateBook(id, book);
    }
}
