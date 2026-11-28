package it.rotech.libreria.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import it.rotech.libreria.entity.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {

    Optional<Utente> findByUsername(String username);
}
