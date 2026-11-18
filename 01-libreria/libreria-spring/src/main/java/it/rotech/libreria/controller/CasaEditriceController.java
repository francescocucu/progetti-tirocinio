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

import it.rotech.libreria.dto.CasaEditriceDTO;
import it.rotech.libreria.dto.CasaEditriceForm;
import it.rotech.libreria.service.CasaEditriceService;

@RestController 
@RequestMapping ("/caseeditrici")
public class CasaEditriceController {

    private CasaEditriceService casaEditriceService;

    public CasaEditriceController(CasaEditriceService casaEditriceService) {
        this.casaEditriceService = casaEditriceService;
    }

    @GetMapping 
    private List<CasaEditriceDTO> findAll (){
        return casaEditriceService.findAll();
    }

    @GetMapping ("/{id}")
    private CasaEditriceDTO findById (Integer id){
        return casaEditriceService.findById(id);
    }

    @PostMapping 
    public void addCasaEditrice (@RequestBody CasaEditriceForm casaEditriceForm){
        casaEditriceService.addCasaEditrice(casaEditriceForm);
    }

    @PutMapping ("/{id}")
    private void updateCasaEditrice (@PathVariable  Integer id, @RequestBody CasaEditriceForm casaEditriceForm){
        casaEditriceService.updateCasaEditrice(id, casaEditriceForm);
    }

    @DeleteMapping ("/{id}")
    private void deleteCasaEditrice (@PathVariable Integer id){
        casaEditriceService.deleteCasaEditrice(id);
    }

}
