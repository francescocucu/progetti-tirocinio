package it.rotech.libreria.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LibroForm {

    @NotBlank(message = "Il titolo è obbligatorio")
    @Size(max = 100, message = "Il titolo può avere al massimo 100 caratteri") // @Size(max = 100): rispecchia il
                                                                               // varchar(100) della tabella libri
    private String titolo;
    @Min(value = 0, message = "L'anno non può essere negativo")
    private Integer anno;
    @NotBlank(message = "Il genere è obbligatorio")
    private String nomeGenere;
    @Valid // listaAutori è l'unico campo che contiene altri oggetti
    // con le loro regole. @Valid sul campo gli dice:
    // "apri anche questi e controlla le regole al loro interno".
    @NotEmpty(message = "Serve almeno un autore")
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
