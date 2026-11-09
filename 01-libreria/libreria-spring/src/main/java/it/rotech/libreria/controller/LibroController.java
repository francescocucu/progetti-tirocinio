package it.rotech.libreria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rotech.libreria.service.LibroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping ("/libri")
public class LibroController {

    private LibroService libroService;

     public LibroController (LibroService libroService){
        this.libroService = libroService;
     }

     @GetMapping
     public 
     
    

}
