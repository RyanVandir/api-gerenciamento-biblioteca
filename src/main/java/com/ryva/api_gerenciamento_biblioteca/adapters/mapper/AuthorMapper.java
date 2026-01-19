package com.ryva.api_gerenciamento_biblioteca.adapters.mapper;

import com.ryva.api_gerenciamento_biblioteca.adapters.in.dto.AuthorCreateResponse;
import com.ryva.api_gerenciamento_biblioteca.adapters.in.dto.AuthorDto;
import com.ryva.api_gerenciamento_biblioteca.adapters.in.dto.AuthorResponse;
import com.ryva.api_gerenciamento_biblioteca.adapters.out.entity.AuthorEntity;
import com.ryva.api_gerenciamento_biblioteca.domain.model.Author;
import com.ryva.api_gerenciamento_biblioteca.domain.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuthorMapper {

    // DOMAIN -> API
    List<AuthorResponse> toResponse(List<Author> authors);

    AuthorResponse toResponse(Author author);

    // DOMAIN -> API POST RESPONSE
    default AuthorCreateResponse toCreateResponse(Author author) {
        return new AuthorCreateResponse(
                author.getId(),
                author.getName(),
                author.getNationality()
        );
    }

    // API -> DOMAIN
    default Author toModel(AuthorDto authorDto) {
        return new Author(authorDto.name(),
                authorDto.nationality());
    }

    // ENTITY -> DOMAIN
    default Author toModel(AuthorEntity authorEntity) {
        Author author = new Author(
                authorEntity.getId(),
                authorEntity.getName(),
                authorEntity.getNationality(),
                new ArrayList<>());

        List<Book> books = authorEntity.getBooks() == null ?
                List.of()
                : authorEntity.getBooks().stream()
                .map(bookEntity -> new Book(
                                bookEntity.getId(),
                                bookEntity.getTitle(),
                                bookEntity.getYearPublished(),
                                author.getId()
                        )
                ).toList();
        author.getBooks().addAll(books);
        return author;
    }

    List<Author> toModel(List<AuthorEntity> authorEntities);

    // DOMAIN -> ENTITY
    AuthorEntity toEntity(Author author);

}
