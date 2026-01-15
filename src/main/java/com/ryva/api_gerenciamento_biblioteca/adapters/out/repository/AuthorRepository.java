package com.ryva.api_gerenciamento_biblioteca.adapters.out.repository;

import com.ryva.api_gerenciamento_biblioteca.adapters.out.entity.AuthorEntity;
import com.ryva.api_gerenciamento_biblioteca.domain.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
}
