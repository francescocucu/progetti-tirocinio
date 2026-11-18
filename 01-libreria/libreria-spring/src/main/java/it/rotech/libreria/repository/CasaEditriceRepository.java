package it.rotech.libreria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.rotech.libreria.entity.CasaEditrice;

public interface CasaEditriceRepository extends JpaRepository<CasaEditrice, Integer> {

    Boolean existsByNomeIgnoreCase(String nome);
    Optional <CasaEditrice> findByNomeIgnoreCase(String nome);

}
