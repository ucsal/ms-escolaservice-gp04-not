package com.equipe4.escolaservice.service;

import com.equipe4.escolaservice.dto.CriarEscolaDto;
import com.equipe4.escolaservice.dto.EscolaResponseDto;
import com.equipe4.escolaservice.model.Escola;
import com.equipe4.escolaservice.repository.EscolaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EscolaService {

    private final EscolaRepository escolaRepository;

    public EscolaService(EscolaRepository escolaRepository) {
        this.escolaRepository = escolaRepository;
    }

    public UUID criarEscola(CriarEscolaDto dto) {
        Escola escola = new Escola(dto.nome(), dto.coordenador(), dto.iesId(), dto.iesNome());
        escolaRepository.save(escola);
        return escola.getId();
    }

    public List<EscolaResponseDto> findAllEscolas() {
        return escolaRepository.findAllByAtivoTrue()
                .stream()
                .map(e -> new EscolaResponseDto(
                        e.getId(),
                        e.getNome(),
                        e.getCoordenador(),
                        e.getIesNome(),
                        false
                ))
                .toList();
    }

    public void excluirEscola(UUID id) {
        Escola escola = escolaRepository.findById(id).orElseThrow();
        escola.desativarEscola();
        escolaRepository.save(escola);
    }
}
