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

import it.rotech.libreria.dto.CopiaDTO;
import it.rotech.libreria.dto.CopiaForm;
import it.rotech.libreria.service.CopiaService;

@RestController
@RequestMapping("/copie")
public class CopiaController {

    private CopiaService copiaService;

    public CopiaController(CopiaService copiaService) {
        this.copiaService = copiaService;
    }

    @GetMapping
    public List<CopiaDTO> findAll() {
        return copiaService.findAll();
    }

    @GetMapping("/{id}")
    public CopiaDTO findById(@PathVariable Integer id) {
        return copiaService.findById(id);
    }

    @PostMapping
    public void addCopia(@RequestBody CopiaForm copiaForm) {
        copiaService.addCopia(copiaForm);
    }

    @PutMapping("/{id}")
    public void updateCopia(@PathVariable Integer id, @RequestBody CopiaForm copiaForm) {
        copiaService.updateCopia(id, copiaForm);
    }

    @DeleteMapping("/{id}")
    public void deleteCopia(@PathVariable Integer id) {
        copiaService.deleteCopia(id);
    }

}
