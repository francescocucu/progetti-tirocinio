package it.rotech.libreria.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

/**
 * AutoreForm
 */
public class AutoreForm {
    @NotBlank(message = "Il nome dell'autore è obbligatorio")
    @Size(max = 100, message = "Il nome può avere al massimo 100 caratteri")
    private String nome;
    @NotBlank(message = "Il cognome dell'autore è obbligatorio")
    @Size(max = 100, message = "Il cognome può avere al massimo 100 caratteri")
    private String cognome;
    @NotNull(message = "La data di nascita è obbligatoria") /*
                                                             * data di nascita obbligatoria: non perché lo chieda il
                                                             * database (lì può essere vuota),
                                                             * ma perché il service cerca l'autore con nome, cognome
                                                             * e data. Senza la data, la ricerca non funziona;
                                                             */

    @Past(message = "La data di nascita deve essere nel passato")
    private LocalDate dataDiNascita;
    @Size(max = 100, message = "La nazionalità può avere al massimo 100 caratteri")
    private String nazionalita;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }

    public AutoreForm() {
    }

}
