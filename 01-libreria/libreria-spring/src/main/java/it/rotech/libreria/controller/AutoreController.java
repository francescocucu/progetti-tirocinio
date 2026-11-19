package it.rotech.libreria.controller;

import java.util.List;

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

@RestController 
@RequestMapping ("/autori")

public class AutoreController {

    private AutoreService autoreService;

    public AutoreController(AutoreService autoreService) {
        this.autoreService = autoreService;
    }

    @GetMapping 
    public List<AutoreDTO> findAll (){
        return autoreService.findAll();
    }

    @GetMapping ("/{id}")
    public AutoreDTO findById (@PathVariable Integer id){
        return autoreService.findById(id);
    }

    @PostMapping 
    public void addAutore (@RequestBody AutoreForm autoreForm){
        autoreService.addAutore(autoreForm);
    }

    @PutMapping ("/{id}")
    public void updateAutore (@PathVariable Integer id, @RequestBody  AutoreForm autoreForm){
        autoreService.updateAutore(id, autoreForm);
    }

    @DeleteMapping ("/{id}")
    public void deleteAutore (@PathVariable Integer id){
        autoreService.deleteAutore(id);
    }
}
