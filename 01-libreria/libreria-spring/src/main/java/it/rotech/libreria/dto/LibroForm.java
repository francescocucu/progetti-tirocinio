package it.rotech.libreria.dto;

import java.util.ArrayList;
import java.util.List;

public class LibroForm {

    private String titolo;
    private Integer anno;
    private Integer genereId;
    private List<Integer> listaAutoriID = new ArrayList<>();
        
    
    public LibroForm() {
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
    
    public Integer getGenereId() {
        return genereId;
    }


    public void setGenereId(Integer genereId) {
        this.genereId = genereId;
    }

     public List<Integer> getListaAutoriID() {
        return listaAutoriID;
    }

    public void setListaAutoriID(List<Integer> listaAutoriID) {
        this.listaAutoriID = listaAutoriID;
    }


    

}
