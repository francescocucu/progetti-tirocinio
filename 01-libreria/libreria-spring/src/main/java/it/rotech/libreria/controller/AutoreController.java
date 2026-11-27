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

import it.rotech.libreria.dto.AutoreDTO;
import it.rotech.libreria.dto.AutoreForm;
import it.rotech.libreria.service.AutoreService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;


//SACRO PRONTUARIO:
/*Metodo	                   Return
GET (tutti e per id)	      ResponseEntity.ok(...)
POST                    	ResponseEntity.status(HttpStatus.CREATED).build()
PUT                     	ResponseEntity.ok().build()
DELETE                  	ResponseEntity.noContent().build()*/
 

@RestController 
@RequestMapping ("/autori")
@Validated
public class AutoreController {

    private AutoreService autoreService;

    public AutoreController(AutoreService autoreService) {
        this.autoreService = autoreService;
    }

    @GetMapping 
    public ResponseEntity<List<AutoreDTO>> findAll (){
        return ResponseEntity.ok(autoreService.findAll());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<AutoreDTO> findById (@PathVariable @Min(1) Integer id){
        return ResponseEntity.ok(autoreService.findById(id));
    }

    @PostMapping 
    public ResponseEntity<Void> addAutore (@Valid @RequestBody AutoreForm autoreForm){
        autoreService.addAutore(autoreForm);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Void> updateAutore (@Valid @PathVariable @Min(1) Integer id, @RequestBody  AutoreForm autoreForm){
        autoreService.updateAutore(id, autoreForm);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteAutore (@PathVariable @Min(1) Integer id){
        autoreService.deleteAutore(id);
        return ResponseEntity.noContent().build();
    }
}
