package it.rotech.libreria.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rotech.libreria.dto.LibroDTO;
import it.rotech.libreria.dto.LibroForm;
import it.rotech.libreria.service.LibroService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import org.springframework.web.bind.annotation.PutMapping;

//PRONTUARIO:
/*Metodo	                   Return
GET (tutti e per id)	      ResponseEntity.ok(...)
POST                    	ResponseEntity.status(HttpStatus.CREATED).build()
PUT                     	ResponseEntity.ok().build()
DELETE                  	ResponseEntity.noContent().build()*/


@RestController
@RequestMapping("/libri")
@Validated
public class LibroController {

   private LibroService libroService;

   public LibroController(LibroService libroService) {
      this.libroService = libroService;
   }

   @GetMapping
   public ResponseEntity<List<LibroDTO>> findAll() {
      return ResponseEntity.ok(libroService.findAll());

   }

   // @PathVariable legge un valore dall’indirizzo (/libri/5)
   @GetMapping("{id}")
   public ResponseEntity<LibroDTO> findById(@PathVariable @Min(1) Integer id) {
      return ResponseEntity.ok(libroService.findById(id)); 
   }

   // @RequestBody legge l’oggetto dal corpo della richiesta.
   @PostMapping
   public ResponseEntity<Void> addLibro(@Valid @RequestBody LibroForm libroForm) {
      libroService.addLibro(libroForm);
      return ResponseEntity.status(HttpStatus.CREATED).build();
   }

   @PutMapping("/{id}")
   public ResponseEntity<Void> updateLibro(@Valid @PathVariable @Min(1) Integer id, @RequestBody LibroForm libroForm) {
      libroService.updateLibro(id, libroForm);
      return ResponseEntity.ok().build();

   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteLibro(@PathVariable @Min(1) Integer id){
      libroService.deleteLibro(id);
      return ResponseEntity.noContent().build();
   }

}
