package com.ryva.api_gerenciamento_biblioteca.adapters.out.entity;

import com.ryva.api_gerenciamento_biblioteca.domain.model.Book;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String nationality;
}
