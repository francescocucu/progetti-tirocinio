package it.rotech.libreria.dto;

public class CasaEditriceDTO {

private Integer id;
private String nome;


public Integer getId() {
    return id;
}

public void setId(Integer id){
    this.id = id;
}

public String getNome() {
    return nome;
}
public void setNome(String nome) {
    this.nome = nome;
}

//costr vuoto
public CasaEditriceDTO() {
}

//costr param
public CasaEditriceDTO(Integer id, String nome) {
    this.id = id;
    this.nome = nome;
}


}
