package com.curso_api.mapper;

import com.curso_api.dto.CursoRequestDTO;
import com.curso_api.dto.CursoResponseDTO;
import com.curso_api.entity.Curso;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.lang.annotation.Target;

@Mapper(componentModel = "spring")
public interface CursoMapper {
    //Ele mapeia automaticamente campos com o mesmo
    //em alguns casos que os campos possuem nomes diferentes precisa explicar como sera feito
    @Mapping(source = "instrutor.nome", target = "instrutorNome")
    CursoResponseDTO toResponse(Curso curso);

    //n mapeia o id porque estamos criando um novo curso
    //o instrutorId nao pode ser convertido direto para uma classe instrutor
    //isso ainda e preciso ser feito pelo service
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "instrutor", ignore = true)
    Curso toEntity(CursoRequestDTO cursoRequestDTO);

    //o id nunca deve ser alterado uma vez que ja foi salvo
    @Mapping(target = "id", ignore = true)
    void update(CursoRequestDTO dto, @MappingTarget Curso curso);
    }


