package com.curso_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CursoRequestDTO(
        @NotBlank(message = "Nome do curso obrigatorio")
        String nome,
        @NotBlank(message = "Descricao obrigatoria")
        String descricao,
        @NotNull(message = "Carga horaria e obrigatoria")
        Integer cargaHoraria,
        @NotNull(message = "instrutor obrigatorio")
        Long instrutorId
) {
}
