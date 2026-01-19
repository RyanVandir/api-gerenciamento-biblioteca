package com.ryva.api_gerenciamento_biblioteca.adapters.in.assembler;

import com.ryva.api_gerenciamento_biblioteca.adapters.in.dto.AuthorCreateResponse;
import com.ryva.api_gerenciamento_biblioteca.adapters.in.dto.AuthorDto;
import com.ryva.api_gerenciamento_biblioteca.adapters.in.dto.AuthorResponse;
import com.ryva.api_gerenciamento_biblioteca.adapters.mapper.AuthorMapper;
import com.ryva.api_gerenciamento_biblioteca.domain.model.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorAssembler {

    private final AuthorMapper authorMapper;

    // API (DTO) -> DOMAIN
    public Author toModel(AuthorDto authorDto) {
        return authorMapper.toModel(authorDto);
    }

    // DOMAIN -> API (RESPONSE)
    public AuthorResponse toResponse(Author author) {
        return authorMapper.toResponse(author);
    }

    public AuthorCreateResponse toCreateResponse(Author author) {
        return authorMapper.toCreateResponse(author);
    }

    public List<AuthorResponse> toResponse(List<Author> authors) {
        return authorMapper.toResponse(authors);
    }
}
