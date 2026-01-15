package com.ryva.api_gerenciamento_biblioteca.adapters.in.assembler;

import com.ryva.api_gerenciamento_biblioteca.adapters.in.dto.BookDto;
import com.ryva.api_gerenciamento_biblioteca.adapters.in.dto.BookResponse;
import com.ryva.api_gerenciamento_biblioteca.adapters.mapper.BookMapper;
import com.ryva.api_gerenciamento_biblioteca.domain.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookAssembler {

    private final BookMapper bookMapper;

    // API (DTO) -> DOMAIN
    public Book toModel(BookDto bookDto) {
        return bookMapper.toModel(bookDto);
    }

    // DOMAIN -> API (RESPONSE)
    public BookResponse toResponse(Book book) {
        return bookMapper.toResponse(book);
    }

    public List<BookResponse> toResponse(List<Book> books) {
        return bookMapper.toResponse(books);
    }
}
