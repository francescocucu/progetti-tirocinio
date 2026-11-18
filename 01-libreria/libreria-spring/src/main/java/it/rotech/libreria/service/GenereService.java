package it.rotech.libreria.service;

import it.rotech.libreria.repository.LibroRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.rotech.libreria.dto.GenereDTO;
import it.rotech.libreria.dto.GenereForm;
import it.rotech.libreria.entity.Genere;
import it.rotech.libreria.entity.Libro;
import it.rotech.libreria.repository.GenereRepository;
import it.rotech.libreria.utility.Mapper;
import jakarta.transaction.Transactional;

@Service
public class GenereService {

    private final LibroRepository libroRepository;
    private final GenereRepository genereRepository;
    private final Mapper mapper;

    public GenereService(GenereRepository genereRepository, Mapper mapper, LibroRepository libroRepository) {
        this.genereRepository = genereRepository;
        this.mapper = mapper;
        this.libroRepository = libroRepository;
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
    public void deleteGenere(Integer id) {
        Genere genere = genereRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genere con id '" + id + "' non trovato"));

        List<Libro> risultato = libroRepository.findAll();
        for (Libro libro : risultato) {
            if (libro.getGenere().getId().equals(id)) {
                throw new RuntimeException("nun se po' fa");
            } 
        }
    
                genereRepository.delete(genere);

    }
}// end class
