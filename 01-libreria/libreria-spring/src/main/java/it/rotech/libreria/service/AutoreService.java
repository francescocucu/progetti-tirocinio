package it.rotech.libreria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.rotech.libreria.dto.AutoreDTO;
import it.rotech.libreria.dto.AutoreForm;
import it.rotech.libreria.entity.Autore;
import it.rotech.libreria.exception.ConflictException;
import it.rotech.libreria.exception.NotFoundException;
import it.rotech.libreria.repository.AutoreRepository;
import it.rotech.libreria.utility.Mapper;

@Service
public class AutoreService {

    private final AutoreRepository autoreRepository;
    private final Mapper mapper;

    public AutoreService(AutoreRepository autoreRepository, Mapper mapper) {
        this.autoreRepository = autoreRepository;
        this.mapper = mapper;
    }

    public List<AutoreDTO> findAll() {
        List<Autore> risultato = autoreRepository.findAll();
        List<AutoreDTO> autoreDTO = new ArrayList<>();
        for (Autore autore : risultato) {
            autoreDTO.add(mapper.convertAutoreToAutoreDTO(autore));

        }
        return autoreDTO;

    }

    public AutoreDTO findById(Integer id) {
        Autore risultato = autoreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Autore con id " + " non trovato"));

        return mapper.convertAutoreToAutoreDTO(risultato);

    }

    public void addAutore(AutoreForm autoreForm) {

        boolean sePresente = autoreRepository.existsByNomeIgnoreCaseAndCognomeIgnoreCaseAndDataNascita(
                autoreForm.getNome(), autoreForm.getCognome(), autoreForm.getDataDiNascita());
        if (sePresente == true)
            throw new ConflictException("Autore già presentre nel DB");

        autoreRepository.save(mapper.convertAutoreFormToAutore(autoreForm));

    }

    public void updateAutore(Integer id, AutoreForm autoreForm) {
        Autore autore = autoreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Autore con id " + id + " non trovato"));

        autoreRepository.save(mapper.updateAutoreFormToAutore(autore, autoreForm));

    }

    public void deleteAutore(Integer id) {
        Autore autore = autoreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Autore con id " + id + " non trovato"));
        autoreRepository.delete(autore);
    }

}// end class
