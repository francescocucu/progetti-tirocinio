package it.rotech.libreria.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "libri")

public class Libro {

    /*create table libri (
id int primary key auto_increment,
titolo varchar (100) not null,
anno int,
id_genere int,
foreign key (id_genere) references generi(id)
);*/

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String titolo;
    private Integer anno;

      /*!!!!!     private Integer id_genere...?      NOO!!!!!!!!!
     è proprio qui la differenza con SQL. 
     Nel database c’è il numero id_genere, mentre in Java tieni l’oggetto intero: -----> private Genere genere.
     Il numero lo nomini solo dentro @JoinColumn, perché Hibernate sappia quale colonna usare.*/

    @ManyToOne
    @JoinColumn (name = "id_genere") //name = "come si chiama la fk dentro la tabella libri?"
    private Genere genere;

    /*essendo una relazione n-n le cose si complicano
    va dichiarato il nome della tabella di collegamento (name), il nome della fk rivolta a questa entità, Libro (joinColumns),
    e il nome della fk rivolta all'altra entità, Autore (inverseJoinColumns)*/
    @ManyToMany 
    @JoinTable (
        name = "libri_autori",  // nome della tabella di collegamento 
        joinColumns = @JoinColumn (name="id_libri"), //FK verso QUESTA entità (Libro)
        inverseJoinColumns = @JoinColumn(name = "id_autori") // FK verso l'ALTRA entità (Autore)
          )
    private Set<Autore> autori = new HashSet<>();

    //Getter di Id e getter e setter del resto

    public Integer getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }


    //costruttore vuoto
    public Libro() {
    }

        //costruttore param

    public Libro(String titolo, Integer anno, Genere genere) {
        this.titolo = titolo;
        this.anno = anno;
        this.genere = genere;
    }

 
    }
    
  
    


