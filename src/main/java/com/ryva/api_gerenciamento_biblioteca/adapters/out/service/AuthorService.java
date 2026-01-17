package com.ryva.api_gerenciamento_biblioteca.adapters.out.service;

import com.ryva.api_gerenciamento_biblioteca.adapters.mapper.AuthorMapper;
import com.ryva.api_gerenciamento_biblioteca.adapters.out.entity.AuthorEntity;
import com.ryva.api_gerenciamento_biblioteca.adapters.out.repository.AuthorRepository;
import com.ryva.api_gerenciamento_biblioteca.domain.exception.AuthorNotFoundException;
import com.ryva.api_gerenciamento_biblioteca.domain.model.Author;
import com.ryva.api_gerenciamento_biblioteca.port.out.AuthorServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorService implements AuthorServicePort {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;


    @Override
    public boolean existById(Integer id) {
       return  authorRepository.existsById(id);
    }

    @Override
    public Author createAuthor(Author author) {
        return authorMapper.toModel(authorRepository.save(authorMapper.toEntity(author)));
    }

    @Override
    public List<Author> listAuthors() {
        return authorMapper.toModel(authorRepository.findAll());
    }

    @Override
    public Author deleteAuthor(Integer id) {
        AuthorEntity authorEntity = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("Nenhum autor encontrado"));
        authorRepository.delete(authorEntity);
        return authorMapper.toModel(authorEntity);
    }

    @Override
    public Author findById(Integer id) {
        AuthorEntity authorEntity = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("Nenhum autor encontrado"));
        return authorMapper.toModel(authorEntity);
    }
}
