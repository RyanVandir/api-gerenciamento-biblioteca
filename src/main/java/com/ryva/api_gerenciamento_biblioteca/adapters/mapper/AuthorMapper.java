package com.ryva.api_gerenciamento_biblioteca.adapters.mapper;

import com.ryva.api_gerenciamento_biblioteca.adapters.in.dto.AuthorDto;
import com.ryva.api_gerenciamento_biblioteca.adapters.in.dto.AuthorResponse;
import com.ryva.api_gerenciamento_biblioteca.adapters.out.entity.AuthorEntity;
import com.ryva.api_gerenciamento_biblioteca.domain.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuthorMapper {

    // DOMAIN -> API
    List<AuthorResponse> toResponse(List<Author> authors);
    AuthorResponse toResponse(Author author);

    // API -> DOMAIN
    default Author toModel(AuthorDto authorDto){
     return new Author(authorDto.name(),
             authorDto.nationality());
    }

    // ENTITY -> DOMAIN
    default Author toModel(AuthorEntity authorEntity){
     return new Author(authorEntity.getId(),
             authorEntity.getName(),
             authorEntity.getNationality());
    }
    List<Author> toModel(List<AuthorEntity> authorEntities);

    // DOMAIN -> ENTITY
    AuthorEntity toEntity(Author author);

}
