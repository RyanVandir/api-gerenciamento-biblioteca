package com.ryva.api_gerenciamento_biblioteca.adapters.mapper;

import com.ryva.api_gerenciamento_biblioteca.adapters.in.dto.BookDto;
import com.ryva.api_gerenciamento_biblioteca.adapters.in.dto.BookResponse;
import com.ryva.api_gerenciamento_biblioteca.adapters.out.entity.AuthorEntity;
import com.ryva.api_gerenciamento_biblioteca.adapters.out.entity.BookEntity;
import com.ryva.api_gerenciamento_biblioteca.domain.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {

    // API -> DOMAIN
    default Book toModel(BookDto bookDto) {
        return new Book(bookDto.title(),
                bookDto.yearPublished(),
                bookDto.authorId());
    }
    // DOMAIN -> API
    BookResponse toResponse(Book book);
    List<BookResponse> toResponse(List<Book> books);

    // ENTITY -> DOMAIN
    default Book toModel(BookEntity bookEntity) {
        return new Book(bookEntity.getId(),
                bookEntity.getTitle(),
                bookEntity.getYearPublished(),
                bookEntity.getAuthor().getId());
    }

    List<Book>  toModel(List<BookEntity> bookEntities);

    // DOMAIN -> ENTITY
    @Mapping(source = "authorId", target = "author")
    BookEntity toEntity(Book book);

    // Conversão FK -> ENTITY
    default AuthorEntity map(Integer authorId) {
        if (authorId == null){
            return null;
        }
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setId(authorId);
        return authorEntity;
    }
}
