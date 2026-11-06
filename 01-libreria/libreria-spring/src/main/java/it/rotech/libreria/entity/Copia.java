package it.rotech.libreria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "copie")

public class Copia {

    /*
     * create table copie (
     * id int primary key auto_increment,
     * numero_copie int not null,
     * case_editrici_id int,
     * foreign key (case_editrici_id) references case_editrici(id),
     * libri_id int,
     * foreign key (libri_id) references libri(id)
     * );
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private Integer numeroCopie;

    // fk di case editrici
    @ManyToOne
    @JoinColumn(name = "case_editrici_id")
    private CasaEditrice casaEditrice;

    // fk di libri
    @ManyToOne
    @JoinColumn(name = "libri_id")
    private Libro libro;

    // get di id e gli altri getter e setter
    public Integer getId() {
        return id;
    }

    public Integer getNumeroCopie() {
        return numeroCopie;
    }

    public void setNumeroCopie(Integer numeroCopie) {
        this.numeroCopie = numeroCopie;
    }

    public CasaEditrice getCasaEditrice() {
        return casaEditrice;
    }

    public void setCasaEditrice(CasaEditrice casaEditrice) {
        this.casaEditrice = casaEditrice;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    // costruttore vuoto
    public Copia() {
    }

    // costruttore param
    public Copia(Integer id, Integer numeroCopie, CasaEditrice casaEditrice, Libro libro) {
        this.id = id;
        this.numeroCopie = numeroCopie;
        this.casaEditrice = casaEditrice;
        this.libro = libro;
    }

}
