package com.ryva.api_gerenciamento_biblioteca.adapters.in.controller;

import com.ryva.api_gerenciamento_biblioteca.adapters.in.assembler.BookAssembler;
import com.ryva.api_gerenciamento_biblioteca.adapters.in.dto.BookDto;
import com.ryva.api_gerenciamento_biblioteca.adapters.in.dto.BookResponse;
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

    private final BookAssembler bookAssembler;
    private final BookUseCasePort bookUseCase;

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok(
                bookAssembler.toResponse(bookUseCase.createdBook(bookAssembler.toModel(bookDto)))
        );
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> getBooks() {
        return ResponseEntity.ok(
                bookAssembler.toResponse(bookUseCase.listBooks())
        );
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable Integer id,
                                                   @RequestBody BookDto bookDto) {
        return ResponseEntity.ok(
                bookAssembler.toResponse(bookUseCase.updateBook(id, bookAssembler.toModel(bookDto)))
        );
    }

}
