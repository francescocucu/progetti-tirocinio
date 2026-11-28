package it.rotech.libreria.service;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private final SecretKey chiave;
    private final long scadenza;

    // Il costruttore legge i due valori da application.properties
    public JwtService(@Value("${jwt.segreto}") String segreto,
            @Value("${jwt.scadenza}") long scadenza) {
        this.chiave = Keys.hmacShaKeyFor(segreto.getBytes(StandardCharsets.UTF_8));
        this.scadenza = scadenza;
    }

    // CREA il token per un utente
    public String generaToken(String username) {
        Date adesso = new Date();
        return Jwts.builder()
                .subject(username)
                .issuedAt(adesso)
                .expiration(new Date(adesso.getTime() + scadenza))
                .signWith(chiave)
                .compact();
    }

    // LEGGE il token e restituisce lo username
    // (se il token è falso o scaduto, lancia un'eccezione)
    public String estraiUsername(String token) {
        return Jwts.parser()
                .verifyWith(chiave)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}