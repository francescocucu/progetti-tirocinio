package it.rotech.libreria.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.rotech.libreria.entity.Autore;

public interface AutoreRepository extends JpaRepository<Autore, Integer> {
Optional<Autore> findByNomeIgnoreCaseAndCognomeIgnoreCaseAndDataNascita(
        String nome, String cognome, LocalDate dataDiNascita);
}
