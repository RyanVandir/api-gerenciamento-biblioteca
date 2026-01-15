package com.ryva.api_gerenciamento_biblioteca.adapters.out.repository;

import com.ryva.api_gerenciamento_biblioteca.adapters.out.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
}
