package it.rotech.libreria.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


//PRONTUARIO:
/*Metodo	                   Return
GET (tutti e per id)	      ResponseEntity.ok(...)
POST                    	ResponseEntity.status(HttpStatus.CREATED).build()
PUT                     	ResponseEntity.ok().build()
DELETE                  	ResponseEntity.noContent().build()*/

@RestController 
@RequestMapping ("/caseeditrici")
public class CasaEditriceController {

    private CasaEditriceService casaEditriceService;

    public CasaEditriceController(CasaEditriceService casaEditriceService) {
        this.casaEditriceService = casaEditriceService;
    }

    @GetMapping 
    public ResponseEntity<List<CasaEditriceDTO>> findAll (){
        return ResponseEntity.ok(casaEditriceService.findAll()) ;
    }

    @GetMapping ("/{id}")
    public ResponseEntity<CasaEditriceDTO> findById (@PathVariable Integer id){
        return  ResponseEntity.ok(casaEditriceService.findById(id));
    }

    @PostMapping 
    public ResponseEntity<Void> addCasaEditrice (@RequestBody CasaEditriceForm casaEditriceForm){
        casaEditriceService.addCasaEditrice(casaEditriceForm);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Void> updateCasaEditrice (@PathVariable  Integer id, @RequestBody CasaEditriceForm casaEditriceForm){
        casaEditriceService.updateCasaEditrice(id, casaEditriceForm);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteCasaEditrice (@PathVariable Integer id){
        casaEditriceService.deleteCasaEditrice(id);
        return ResponseEntity.noContent().build();
    }

}
