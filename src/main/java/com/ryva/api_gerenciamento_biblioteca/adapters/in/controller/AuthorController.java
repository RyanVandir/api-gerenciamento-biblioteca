package com.ryva.api_gerenciamento_biblioteca.adapters.in.controller;

import com.ryva.api_gerenciamento_biblioteca.adapters.in.assembler.AuthorAssembler;
import com.ryva.api_gerenciamento_biblioteca.adapters.in.dto.AuthorCreateResponse;
import com.ryva.api_gerenciamento_biblioteca.adapters.in.dto.AuthorDto;
import com.ryva.api_gerenciamento_biblioteca.adapters.in.dto.AuthorResponse;
import com.ryva.api_gerenciamento_biblioteca.port.in.AuthorUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("authors")
@RestController
public class AuthorController {

    private final AuthorUseCasePort authorUseCase;
    private final AuthorAssembler authorAssembler;

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
        public ResponseEntity<AuthorCreateResponse> createAuthor(@RequestBody AuthorDto authorDto) {
        return ResponseEntity.ok(
                authorAssembler.toCreateResponse(
                        authorUseCase.createAuthor(authorAssembler.toModel(authorDto))
                )
        );
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponse>> getAuthors() {
        return ResponseEntity.ok(
                authorAssembler.toResponse(authorUseCase.listAuthors())
        );
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("{id}")
    public ResponseEntity<AuthorResponse> deleteAuthor(@PathVariable Integer id) {
        return ResponseEntity.ok(
                authorAssembler.toResponse(authorUseCase.deleteAuthor(id))
        );
    }
    
    @GetMapping("{id}")
    public ResponseEntity<AuthorResponse> getAuthor(@PathVariable Integer id) {
        return ResponseEntity.ok(
                authorAssembler.toResponse(authorUseCase.findById(id))
        );
    }
}
