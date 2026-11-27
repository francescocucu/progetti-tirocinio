package it.rotech.libreria.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rotech.libreria.dto.GenereDTO;
import it.rotech.libreria.dto.GenereForm;
import it.rotech.libreria.service.GenereService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

//PRONTUARIO:
/*Metodo	                   Return
GET (tutti e per id)	    ResponseEntity.ok(...)
POST                    	ResponseEntity.status(HttpStatus.CREATED).build()
PUT                     	ResponseEntity.ok().build()
DELETE                  	ResponseEntity.noContent().build()*/

@RestController
@RequestMapping("/generi")
@Validated
public class GenereController {

    private GenereService genereService;

    public GenereController(GenereService genereService) {
        this.genereService = genereService;
    }

    // ResponseEntity<List<GenereDTO>> : una busta che contiene una lista di generi
    @GetMapping
    public ResponseEntity<List<GenereDTO>> findAll() {
        return ResponseEntity.ok(genereService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenereDTO> findById(@PathVariable @Min(1) Integer id) {
        return ResponseEntity.ok(genereService.findById(id));
    }

    //il tipo void diventa ResponseEntity<Void>, cioè una busta vuota.
    //occhio alla V maiuscola!!
    @PostMapping
    public ResponseEntity<Void> addGenere(@Valid @RequestBody GenereForm genereForm) {
        genereService.addGenere(genereForm);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateGenere(@PathVariable @Min(1) Integer id,@Valid  @RequestBody GenereForm genereForm) {
        genereService.updateGenere(id, genereForm);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteGenere(@PathVariable @Min(1) Integer id) {
        genereService.deleteGenere(id);
        return ResponseEntity.noContent().build();
    }
}
