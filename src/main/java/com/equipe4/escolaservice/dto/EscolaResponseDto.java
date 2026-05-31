package com.equipe4.escolaservice.dto;

import java.util.UUID;

public record EscolaResponseDto(UUID id, String nomeEscola, String coordenador, String nomeIes, boolean temHistorico) {
}
