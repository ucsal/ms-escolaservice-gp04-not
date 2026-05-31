package com.equipe4.escolaservice.repository;

import com.equipe4.escolaservice.model.Escola;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EscolaRepository extends JpaRepository<Escola, UUID> {

    List<Escola> findAllByAtivoTrue();

    boolean existsByIesId(UUID iesId);
}
