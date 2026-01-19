package com.ryva.api_gerenciamento_biblioteca.adapters.in.dto;

import java.util.List;

public record AuthorResponse(Integer id, String name, String nationality, List<BookResponse> books) {
}
