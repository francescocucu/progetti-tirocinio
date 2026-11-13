package it.rotech.libreria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.rotech.libreria.entity.Genere;

public interface GenereRepository extends JpaRepository <Genere, Integer>{

Optional<Genere> findByNomeIgnoreCase(String nome);
}
