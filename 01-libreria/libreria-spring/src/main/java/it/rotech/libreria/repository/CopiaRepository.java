package it.rotech.libreria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.rotech.libreria.entity.Copia;

public interface CopiaRepository extends JpaRepository <Copia, Integer>{

    public void deleteByLibroId (Integer libroId);
    public void deleteByCasaEditriceId (Integer id);
    Optional<Copia> findByLibroIdAndCasaEditriceId(Integer libroId, Integer casaEditriceId);

}
