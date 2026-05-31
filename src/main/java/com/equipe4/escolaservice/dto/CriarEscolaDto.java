package com.equipe4.escolaservice.dto;

import java.util.UUID;

public record CriarEscolaDto(String nome, String coordenador, UUID iesId, String iesNome) {
}
