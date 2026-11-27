package it.rotech.libreria.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CopiaForm {

    @NotNull(message = "Il numero di copie è obbligatorio")
@Min(value = 0, message = "Il numero di copie non può essere negativo")
    private Integer numeroCopie;
    @NotNull(message = "Il libro è obbligatorio")
    private Integer libroId;
    @NotNull(message = "La casa editrice è obbligatoria")
    private Integer casaEditriceId;

    public Integer getNumeroCopie() {
        return numeroCopie;
    }
    public void setNumeroCopie(Integer numeroCopie) {
        this.numeroCopie = numeroCopie;
    }
    public Integer getLibroId() {
        return libroId;
    }
    public void setLibroId(Integer libroId) {
        this.libroId = libroId;
    }
    public Integer getCasaEditriceId() {
        return casaEditriceId;
    }
    public void setCasaEditriceId(Integer casaEditriceId) {
        this.casaEditriceId = casaEditriceId;
    }
    public CopiaForm() {
    }

    
   

    

    

}
