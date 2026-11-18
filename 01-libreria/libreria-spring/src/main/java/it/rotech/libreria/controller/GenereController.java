package it.rotech.libreria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rotech.libreria.dto.GenereDTO;
import it.rotech.libreria.dto.GenereForm;
import it.rotech.libreria.dto.LibroDTO;
import it.rotech.libreria.service.GenereService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping ("/generi")
public class GenereController {

    private GenereService genereService;

    public GenereController(GenereService genereService) {
        this.genereService = genereService;
    }
    
    @GetMapping
    public List<GenereDTO> findAll(){
        return genereService.findAll();
    }

    @GetMapping("{id}")
   public GenereDTO findById(@PathVariable Integer id) {
      return genereService.findById(id);
   }
    
    @PostMapping 
    public void addGenere (@RequestBody GenereForm genereForm){
         genereService.addGenere(genereForm);
    }

    @PutMapping ("{id}")
    public void updateGenere (@PathVariable Integer id, @RequestBody GenereForm genereForm){
        genereService.updateGenere(id, genereForm);
    }

    @DeleteMapping ("{id}")
    public void deleteGenere (@PathVariable Integer id) {
        genereService.deleteGenere(id);
    }
}

