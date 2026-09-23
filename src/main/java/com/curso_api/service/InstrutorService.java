package com.curso_api.service;

import com.curso_api.dto.InstrutorRequestDTO;
import com.curso_api.dto.InstrutorResponseDTO;
import com.curso_api.entity.Instrutor;
import com.curso_api.mapper.InstrutorMapper;
import com.curso_api.repository.InstrutorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrutorService {
    
    private final InstrutorRepository instrutorRepository;
    private final InstrutorMapper instrutorMapper;

    public InstrutorService(InstrutorRepository instrutorRepository, InstrutorMapper instrutorMapper) {
        this.instrutorRepository = instrutorRepository;
        this.instrutorMapper = instrutorMapper;
    }

    public InstrutorResponseDTO criar(InstrutorRequestDTO dto) {
        Instrutor instrutor = instrutorMapper.toEntity(dto);
        Instrutor salvo = instrutorRepository.save(instrutor);
        return instrutorMapper.toResponse(instrutorRepository.save(instrutor));

    }

    public List<InstrutorResponseDTO> listarTodos() {
        return instrutorRepository
                .findAll()
                .stream()
                .map(i ->instrutorMapper.toResponse(i))
                .toList();
    }

    public InstrutorResponseDTO buscarPorId(Long id) {
        Instrutor instrutor;
        return instrutorMapper
                .toResponse(instrutorRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Instrutor não encontrado com id: " + id)));
    }

    public InstrutorResponseDTO atualizar(Long id, InstrutorRequestDTO dto) {
        Instrutor instrutor = instrutorRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Instrutor não encontrado com id: " + id));
        instrutorMapper.update(dto, instrutor);
        return instrutorMapper.toResponse(instrutorRepository.save(instrutor));
    }

    public void deletar(Long id) {
       instrutorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Instrutor não encontrado com id: " + id));

       instrutorRepository.deleteById(id);
    }

}
