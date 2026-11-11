package it.rotech.libreria.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import it.rotech.libreria.dto.LibroDTO;
import it.rotech.libreria.dto.LibroForm;
import it.rotech.libreria.entity.Autore;
import it.rotech.libreria.entity.Libro;
import it.rotech.libreria.repository.AutoreRepository;
import it.rotech.libreria.repository.GenereRepository;
import it.rotech.libreria.repository.LibroRepository;
import it.rotech.libreria.utility.Mapper;

@Service
public class LibroService {

    private final GenereRepository genereRepository;

    private final LibroRepository libroRepository;

    private final AutoreRepository autoreRepository;
    private final Mapper mapper;

    public LibroService(LibroRepository libroRepository, AutoreRepository autoreRepository, Mapper mapper,
            GenereRepository genereRepository) {
        this.libroRepository = libroRepository;
        this.autoreRepository = autoreRepository;
        this.mapper = mapper;
        this.genereRepository = genereRepository;
    }

    public List<LibroDTO> findAll() {
        List<Libro> risultato = libroRepository.findAll();
        List<LibroDTO> risultatoDTO = new ArrayList<>();
        for (Libro libro : risultato) {
            risultatoDTO.add(mapper.convertLibroToLibroForm(libro));
        }
        return risultatoDTO;
    }

    public LibroDTO findById(Integer id) {
        Libro risultato = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro con id " + id + " non trovato"));
        return (mapper.convertLibroToLibroForm(risultato));
    }

    public void addLibro(LibroForm libroForm) {
        Libro libro = mapper.convertLibroFormToLibro(libroForm);
        libro.setGenere(genereRepository.findById(libroForm.getGenereId())
                .orElseThrow(() -> new RuntimeException("Libro con id " + libroForm.getGenereId() + " non trovato")));
        List<Autore> autoriDalDB = autoreRepository.findAllById(libroForm.getListaAutoriID());
        libro.setAutori(new HashSet<>(autoriDalDB));
        libroRepository.save(libro);

    }

    public void updateLibro(Integer id, LibroForm libroForm) {
        Libro libroDalDB = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro con id " + id + " non trovato"));
        mapper.updateLibroFromForm(libroDalDB, libroForm);
        libroDalDB.setGenere(genereRepository.findById(libroForm.getGenereId())
                .orElseThrow(() -> new RuntimeException("Libro con id " + libroForm.getGenereId() + " non trovato")));
        List<Autore> autoriDalDB = autoreRepository.findAllById(libroForm.getListaAutoriID());
        libroDalDB.setAutori(new HashSet<>(autoriDalDB));
        libroRepository.save(libroDalDB);

    }

    public void deleteLibro(Integer id) {
        Libro libroDalDB = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro con id " + id + " non trovato"));
        libroRepository.delete(libroDalDB);

    }

}
