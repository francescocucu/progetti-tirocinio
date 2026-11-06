package it.rotech.libreria.dto;

public class CopiaDTO {

    private Integer id;
    private Integer numeroCopie;
    private CasaEditriceDTO casaEditrice;
    private LibroDTO libro;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroCopie() {
        return numeroCopie;
    }

    public void setNumeroCopie(Integer numeroCopie) {
        this.numeroCopie = numeroCopie;
    }

    public CasaEditriceDTO getCasaEditrice() {
        return casaEditrice;
    }

    public void setCasaEditrice(CasaEditriceDTO casaEditrice) {
        this.casaEditrice = casaEditrice;
    }

    public LibroDTO getLibro() {
        return libro;
    }

    public void setLibro(LibroDTO libro) {
        this.libro = libro;
    }

    
    //costr vuoto
    public CopiaDTO() {
    }

    //param
    public CopiaDTO(Integer id, Integer numeroCopie, CasaEditriceDTO casaEditrice, LibroDTO libro) {
        this.id = id;
        this.numeroCopie = numeroCopie;
        this.casaEditrice = casaEditrice;
        this.libro = libro;
    }
    
}
