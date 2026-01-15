package com.ryva.api_gerenciamento_biblioteca.usecase;



import com.ryva.api_gerenciamento_biblioteca.domain.exception.AuthorNotFoundException;
import com.ryva.api_gerenciamento_biblioteca.domain.model.Author;
import com.ryva.api_gerenciamento_biblioteca.port.in.AuthorUseCasePort;
import com.ryva.api_gerenciamento_biblioteca.port.out.AuthorServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorUseCase implements AuthorUseCasePort {

    private final AuthorServicePort authorService;

    @Override
    public Author createAuthor(Author author) {
        return authorService.createAuthor(author);
    }

    @Override
    public List<Author> listAuthors() {
        List<Author> authors = authorService.listAuthors();
        if (authors.isEmpty()) {
            throw new AuthorNotFoundException("Nenhum author encontrado");
        }
            return  authors;
    }

    @Override
    public Author deleteAuthor(Integer id) {
        return authorService.deleteAuthor(id);
    }
}
