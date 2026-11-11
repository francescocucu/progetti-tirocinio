package it.rotech.libreria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rotech.libreria.dto.LibroDTO;
import it.rotech.libreria.dto.LibroForm;
import it.rotech.libreria.entity.Libro;
import it.rotech.libreria.service.LibroService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping ("/libri")
public class LibroController {

    private LibroService libroService;

     public LibroController (LibroService libroService){
        this.libroService = libroService;
     }

     @GetMapping
     public List <LibroDTO> getAll (){
      return libroService.findAll();
   
     }

      //@PathVariable legge un valore dall’indirizzo (/libri/5)
     @GetMapping("{id}")
     public LibroDTO getById (@PathVariable Integer id){
      return libroService.findById(id);
     }

     //@RequestBody legge l’oggetto dal corpo della richiesta.
     @PostMapping 
     public void postLibro (@RequestBody LibroForm libroRequest){
      libroService.addLibro(libroRequest);
   }
     
     
     
    

}
