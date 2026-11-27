package it.rotech.libreria.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class GenereForm {

    @NotBlank(message = "Il nome è obbligatorio")
@Size(max = 100, message = "Il nome può avere al massimo 100 caratteri")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GenereForm() {
    }

    

}
