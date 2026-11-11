package it.rotech.libreria.dto;

public class LibroDTO {

    private Integer id;
    private String titolo;
    private Integer anno;
    private GenereDTO genere;

    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
    public GenereDTO getGenere() {
        return genere;
    }
    public void setGenere(GenereDTO genere) {
        this.genere = genere;
    }

    //costruttore vuoto
    public LibroDTO() {
    }
       
      

}
