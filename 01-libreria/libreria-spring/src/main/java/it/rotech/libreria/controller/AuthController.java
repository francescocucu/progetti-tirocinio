package it.rotech.libreria.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rotech.libreria.dto.LoginForm;
import it.rotech.libreria.entity.Utente;
import it.rotech.libreria.repository.UtenteRepository;
import it.rotech.libreria.service.JwtService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UtenteRepository utenteRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthController(UtenteRepository utenteRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.utenteRepository = utenteRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@Valid @RequestBody LoginForm loginForm) {

        // 1. cerco l'utente
        Utente utente = utenteRepository.findByUsername(loginForm.getUsername()).orElse(null);

        // 2. se non esiste, o la password non corrisponde: 401
        if (utente == null || !passwordEncoder.matches(loginForm.getPassword(), utente.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("errore", "Username o password errati"));
        }

        // 3. tutto ok: creo il token e lo restituisco
        String token = jwtService.generaToken(utente.getUsername());
        return ResponseEntity.ok(Map.of("token", token));
    }
}