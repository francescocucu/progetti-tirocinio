package it.rotech.libreria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 1. LE REGOLE: chi può fare cosa

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // vedi sotto
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/**").hasAnyRole("USER", "ADMIN") // leggere: tutti gli utenti
                        .anyRequest().hasRole("ADMIN") // tutto il resto (POST, PUT, DELETE): solo ADMIN
                )
                .httpBasic(Customizer.withDefaults()); // "usa Basic Auth"
        return http.build();
    }

    // 2. COME CIFRARE LE PASSWORD
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 3. GLI UTENTI (per ora scritti qui, in memoria)
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails pingu = User.withUsername("pingu")
                .password(encoder.encode("magma123"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("admin123"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(pingu, admin);
    }

}
