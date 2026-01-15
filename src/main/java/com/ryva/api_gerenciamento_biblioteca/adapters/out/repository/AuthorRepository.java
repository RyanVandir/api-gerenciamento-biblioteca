package com.ryva.api_gerenciamento_biblioteca.adapters.out.repository;

import com.ryva.api_gerenciamento_biblioteca.adapters.out.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
    boolean existsById(Integer id);
}
