package it.rotech.libreria.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/libri")
public class LibroController {

   private LibroService libroService;

   public LibroController(LibroService libroService) {
      this.libroService = libroService;
   }

   @GetMapping
   public List<LibroDTO> findAll() {
      return libroService.findAll();

   }

   // @PathVariable legge un valore dall’indirizzo (/libri/5)
   @GetMapping("{id}")
   public LibroDTO findById(@PathVariable Integer id) {
      return libroService.findById(id);
   }

   // @RequestBody legge l’oggetto dal corpo della richiesta.
   @PostMapping
   public void addLibro(@RequestBody LibroForm libroRequest) {
      libroService.addLibro(libroRequest);
   }

   @PutMapping("/{id}")
   public void updateLibro(@PathVariable Integer id, @RequestBody LibroForm libroForm) {
      libroService.updateLibro(id, libroForm);

   }

   @DeleteMapping("/{id}")
   public void deleteLibro(@PathVariable Integer id){
      libroService.deleteLibro(id);
   }

}
