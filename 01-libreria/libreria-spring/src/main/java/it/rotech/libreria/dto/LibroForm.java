package it.rotech.libreria.dto;

import java.util.ArrayList;
import java.util.List;

public class LibroForm {

    private String titolo;
    private Integer anno;
    private String nomeGenere;
    private List<AutoreForm> listaAutori = new ArrayList<>();
        
    
   
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
    
    public String getNomeGenere() {
        return nomeGenere;
    }


    public void setNomeGenere(String nomeGenere) {
        this.nomeGenere = nomeGenere;
    }

    public List<AutoreForm> getListaAutori() {
        return listaAutori;
    }

    public void setListaAutori(List<AutoreForm> listaAutori) {
        this.listaAutori = listaAutori;
    } 

    
      


    

}
