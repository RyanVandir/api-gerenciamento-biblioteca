package com.ryva.api_gerenciamento_biblioteca.adapters.in.controller;

import com.ryva.api_gerenciamento_biblioteca.adapters.in.dto.BookDto;
import com.ryva.api_gerenciamento_biblioteca.adapters.in.dto.BookResponse;
import com.ryva.api_gerenciamento_biblioteca.adapters.mapper.BookMapper;
import com.ryva.api_gerenciamento_biblioteca.port.in.BookUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("books")
@RestController
public class BookController {

    private final BookMapper bookMapper;
    private final BookUseCasePort bookUseCase;

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok(
                bookMapper.toResponse(bookUseCase.createdBook(bookMapper.toModel(bookDto)))
        );
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> getBooks() {
        return ResponseEntity.ok(
                bookMapper.toResponse(bookUseCase.listBooks())
        );
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable Integer id,
                                           @RequestBody BookDto bookDto) {
        return ResponseEntity.ok(
                bookMapper.toResponse(bookUseCase.updateBook(id, bookMapper.toModel(bookDto)))
        );
    }

}
