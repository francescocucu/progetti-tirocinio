package it.rotech.libreria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rotech.libreria.dto.LibroDTO;
import it.rotech.libreria.entity.Libro;
import it.rotech.libreria.service.LibroService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

     @GetMapping("{id}")
     public LibroDTO getById (@PathVariable Integer id){
      return libroService.findById(id);
     }

     @PostMapping 
     public void postLibro (LibroDTO libroDTO){
     libroService.addLibro(libroDTO);
      
   }
     
     
     
    

}
