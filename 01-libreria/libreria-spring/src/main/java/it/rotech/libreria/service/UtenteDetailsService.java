package it.rotech.libreria.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.rotech.libreria.entity.Utente;
import it.rotech.libreria.repository.UtenteRepository;

@Service
public class UtenteDetailsService implements UserDetailsService {

    private final UtenteRepository utenteRepository;

    public UtenteDetailsService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. cerco l'utente nel MIO database
        Utente utente = utenteRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utente " + username + " non trovato"));

        // 2. lo trasformo nel modulo che capisce Spring Security
        return User.withUsername(utente.getUsername())
                .password(utente.getPassword())
                .roles(utente.getRuolo())
                .build();
    }
}
