package it.rotech.libreria.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "autori")

public class Autore {


    /*create table autore (
id int primary key auto_increment,
nome varchar (100) not null,
cognome varchar (100) not null,
data_nascita date,
nazionalita varchar (100) 
);*/

//solo il getter: l'id lo genera mysql grazie all'annotazione @Generated ecc.
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

//Ho tralasciato la @Column perché superflua, anche nel caso di dataNascita (conversione auto in data_nascita)
private Integer id;
private String nome;
private String cognome;
private LocalDate dataNascita;
private String nazionalita;



public Integer getId() {
    return id;
}
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
public LocalDate getDataNascita() {
    return dataNascita;
}
public void setDataNascita(LocalDate dataNascita) {
    this.dataNascita = dataNascita;
}
public String getNazionalita() {
    return nazionalita;
}
public void setNazionalita(String nazionalita) {
    this.nazionalita = nazionalita;
}

//costruttore vuoto obbligatorio per JPA, perché Hibernate crea l’oggetto vuoto e poi lo riempie con i dati letti dal DB
public Autore() {
}
//parametrizzato:comodo per aggiungere nuovi autori al volo. Credo.
public Autore(String nome, String cognome, LocalDate dataNascita, String nazionalita) {
    this.nome = nome;
    this.cognome = cognome;
    this.dataNascita = dataNascita;
    this.nazionalita = nazionalita;
}


}
