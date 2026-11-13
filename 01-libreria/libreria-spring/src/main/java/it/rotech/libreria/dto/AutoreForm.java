package it.rotech.libreria.dto;

import java.time.LocalDate;

/**
 * AutoreForm
 */
public class AutoreForm {

    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;
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
