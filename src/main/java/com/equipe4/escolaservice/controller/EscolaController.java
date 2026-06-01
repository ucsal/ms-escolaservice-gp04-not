package com.equipe4.escolaservice.controller;

import com.equipe4.escolaservice.dto.CriarEscolaDto;
import com.equipe4.escolaservice.dto.EscolaResponseDto;
import com.equipe4.escolaservice.service.EscolaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/escola")
public class EscolaController {

    private final EscolaService escolaService;

    public EscolaController(EscolaService escolaService) {
        this.escolaService = escolaService;
    }

    @PostMapping
    public ResponseEntity<UUID> criarEscola(@RequestBody CriarEscolaDto dto) {
        var id = escolaService.criarEscola(dto);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public ResponseEntity<List<EscolaResponseDto>> findAllEscolas() {
        return ResponseEntity.ok(escolaService.findAllEscolas());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEscola(@PathVariable UUID id) {
        escolaService.excluirEscola(id);
        return ResponseEntity.noContent().build();
    }
}
