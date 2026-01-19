package com.ryva.api_gerenciamento_biblioteca.adapters.out.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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

    @OneToMany(mappedBy = "author",
            fetch = FetchType.LAZY)
    private List<BookEntity> books =  new ArrayList<>();
}
