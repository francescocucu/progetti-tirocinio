package it.rotech.libreria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.rotech.libreria.dto.GenereDTO;
import it.rotech.libreria.dto.GenereForm;
import it.rotech.libreria.entity.Genere;
import it.rotech.libreria.repository.GenereRepository;
import it.rotech.libreria.utility.Mapper;
import jakarta.transaction.Transactional;

@Service
public class GenereService {

    private final GenereRepository genereRepository;
    private final Mapper mapper;

    public GenereService(GenereRepository genereRepository, Mapper mapper) {
        this.genereRepository = genereRepository;
        this.mapper = mapper;
    }

    public List<GenereDTO> findAll() {
        List<Genere> risultato = genereRepository.findAll();
        List<GenereDTO> risultatoDTO = new ArrayList<>();
        for (Genere genere : risultato) {
            risultatoDTO.add(mapper.convertGenereToGenereDTO(genere));
        }
        return risultatoDTO;
    }

    public GenereDTO findById(Integer id) {
        Genere risultato = genereRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genere con id " + id + " non trovato"));
        return mapper.convertGenereToGenereDTO(risultato);
    }

    public void addGenere(GenereForm genereForm) {
        Genere nuovoGenere = mapper.convertGenereFormToGenere(genereForm);
        genereRepository.save(nuovoGenere);

    }

    public void updateGenere(Integer id, GenereForm genereForm) {

        Genere risultato = genereRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genere con id " + id + " non trovato"));
        risultato.setNome(genereForm.getNome()); // lo fa il mapper ma è più rapido così
        genereRepository.save(risultato);
    }

    /*
     * @Transactional
     * public void deleteLibro(Integer id) {
     * Libro libroDalDB = libroRepository.findById(id) // cerco il libro da bandire
     * .orElseThrow(() -> new RuntimeException("Libro con id " + id +
     * " non trovato"));
     * 
     * copiaRepository.deleteLibroById(id); // cancello ogni sua copia
     * 
     * libroDalDB.getAutori().clear(); // cancello la SUA Lista di autori,
     * manualmente, per prassi
     * 
     * libroRepository.delete(libroDalDB); // lo elimino
     * 
     * }
     */

    @Transactional
    public void deleteGenere(String nomeGenere) { 
        Genere genere = genereRepository.findByNomeIgnoreCase(nomeGenere)
                .orElseThrow(() -> new RuntimeException("Genere '" + nomeGenere + "' non trovato"));
                genereRepository.delete(genere);

    }
}
