package it.rotech.libreria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "generi")

public class Genere {

    /*create table generi (
id int primary key auto_increment,
nome varchar (100) not null
);*/

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

private Integer id;
private String nome;

public Integer getId() {
    return id;
}
public String getNome() {
    return nome;
}
public void setNome(String nome) {
    this.nome = nome;
}

//costruttorre vuoto
public Genere() {
}

//costruttore param

public Genere(String nome) {
    this.nome = nome;
}




}
