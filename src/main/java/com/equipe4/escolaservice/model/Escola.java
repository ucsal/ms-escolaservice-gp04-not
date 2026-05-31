package com.equipe4.escolaservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tb_escola")
@NoArgsConstructor
@Getter
@Setter
public class Escola {

    @Id
    @GeneratedValue
    private UUID id;

    private String nome;
    private String coordenador;

    private UUID iesId;
    private String iesNome;

    private boolean ativo = true;

    public Escola(String nome, String coordenador, UUID iesId, String iesNome) {
        this.nome = nome;
        this.coordenador = coordenador;
        this.iesId = iesId;
        this.iesNome = iesNome;
    }

    public void desativarEscola() {
        this.ativo = false;
    }
}
