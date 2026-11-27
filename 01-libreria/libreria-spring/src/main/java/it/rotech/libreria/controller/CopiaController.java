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

import it.rotech.libreria.dto.CopiaDTO;
import it.rotech.libreria.dto.CopiaForm;
import it.rotech.libreria.service.CopiaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;


//PRONTUARIO:
/*Metodo	                   Return
GET (tutti e per id)	      ResponseEntity.ok(...)
POST                    	ResponseEntity.status(HttpStatus.CREATED).build()
PUT                     	ResponseEntity.ok().build()
DELETE                  	ResponseEntity.noContent().build()*/


@RestController
@RequestMapping("/copie")
@Validated
public class CopiaController {

    private CopiaService copiaService;

    public CopiaController(CopiaService copiaService) {
        this.copiaService = copiaService;
    }

    @GetMapping
    public ResponseEntity<List<CopiaDTO>> findAll() {
        return ResponseEntity.ok(copiaService.findAll()) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CopiaDTO> findById(@PathVariable @Min(1) Integer id) {
        return ResponseEntity.ok(copiaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> addCopia(@Valid @RequestBody CopiaForm copiaForm) {
        copiaService.addCopia(copiaForm);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCopia(@Valid @PathVariable @Min(1) Integer id, @RequestBody CopiaForm copiaForm) {
        copiaService.updateCopia(id, copiaForm);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCopia(@PathVariable @Min(1) Integer id) {
        copiaService.deleteCopia(id);
        return ResponseEntity.noContent().build();
    }

}
