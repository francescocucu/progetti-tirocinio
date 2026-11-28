package it.rotech.libreria.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.JwtException;
import it.rotech.libreria.service.JwtService;
import it.rotech.libreria.service.UtenteDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UtenteDetailsService utenteDetailsService;

    public JwtFilter(JwtService jwtService, UtenteDetailsService utenteDetailsService) {
        this.jwtService = jwtService;
        this.utenteDetailsService = utenteDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 1. leggo l'intestazione "Authorization"
        String intestazione = request.getHeader("Authorization");

        // 2. se c'è e inizia con "Bearer ", prendo il token che viene dopo
        if (intestazione != null && intestazione.startsWith("Bearer ")) {
            String token = intestazione.substring(7);   // "Bearer " sono 7 caratteri

            try {
                // 3. leggo lo username dal token (se è falso o scaduto: eccezione)
                String username = jwtService.estraiUsername(token);

                // 4. carico l'utente dal database, ruolo compreso
                UserDetails utente = utenteDetailsService.loadUserByUsername(username);

                // 5. dico a Spring: "questa richiesta è di questo utente"
                UsernamePasswordAuthenticationToken autenticazione =
                        new UsernamePasswordAuthenticationToken(utente, null, utente.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(autenticazione);

            } catch (JwtException e) {
                // token falso o scaduto: non autentico nessuno
                // (Spring risponderà 401 più avanti)
            }
        }

        // 6. in ogni caso, lascio proseguire la richiesta
        filterChain.doFilter(request, response);
    }
}