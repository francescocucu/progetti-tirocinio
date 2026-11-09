package it.rotech.libreria.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "case_editrici")
public class CasaEditrice {

    /*create table case_editrici (
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
public CasaEditrice() {
}

//costruttore param

public CasaEditrice(String nome) {
    this.nome = nome;
}

}
