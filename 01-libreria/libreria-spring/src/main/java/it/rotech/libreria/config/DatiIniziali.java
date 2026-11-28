package it.rotech.libreria.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import it.rotech.libreria.entity.Utente;
import it.rotech.libreria.repository.UtenteRepository;

@Component
public class DatiIniziali implements CommandLineRunner {

    private final UtenteRepository utenteRepository;
    private final PasswordEncoder passwordEncoder;

    public DatiIniziali(UtenteRepository utenteRepository, PasswordEncoder passwordEncoder) {
        this.utenteRepository = utenteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        creaSeNonEsiste("admin", "admin123", "ADMIN");
        creaSeNonEsiste("pingu", "magma123", "USER");
    }

    private void creaSeNonEsiste(String username, String password, String ruolo) {
        if (utenteRepository.findByUsername(username).isEmpty()) {
            Utente utente = new Utente();
            utente.setUsername(username);
            utente.setPassword(passwordEncoder.encode(password));   // ← cifrata!
            utente.setRuolo(ruolo);
            utenteRepository.save(utente);
        }
    }
}