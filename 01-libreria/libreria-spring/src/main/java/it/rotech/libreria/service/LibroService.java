package it.rotech.libreria.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import it.rotech.libreria.dto.AutoreForm;
import it.rotech.libreria.dto.LibroDTO;
import it.rotech.libreria.dto.LibroForm;
import it.rotech.libreria.entity.Autore;
import it.rotech.libreria.entity.Libro;
import it.rotech.libreria.repository.AutoreRepository;
import it.rotech.libreria.repository.CopiaRepository;
import it.rotech.libreria.repository.GenereRepository;
import it.rotech.libreria.repository.LibroRepository;
import it.rotech.libreria.utility.Mapper;
import jakarta.transaction.Transactional;

@Service
public class LibroService {

    private final GenereRepository genereRepository;
    private final CopiaRepository copiaRepository;

    private final LibroRepository libroRepository;

    private final AutoreRepository autoreRepository;
    private final Mapper mapper;

    public LibroService(LibroRepository libroRepository, AutoreRepository autoreRepository, Mapper mapper,
            GenereRepository genereRepository, CopiaRepository copiaRepository) {
        this.copiaRepository = copiaRepository;
        this.libroRepository = libroRepository;
        this.autoreRepository = autoreRepository;
        this.mapper = mapper;
        this.genereRepository = genereRepository;
    }

    public List<LibroDTO> findAll() {
        List<Libro> risultato = libroRepository.findAll();
        List<LibroDTO> risultatoDTO = new ArrayList<>();
        for (Libro libro : risultato) {
            risultatoDTO.add(mapper.convertLibroToLibroDTO(libro));
        }
        return risultatoDTO;
    }

    public LibroDTO findById(Integer id) {
        Libro risultato = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro con id " + id + " non trovato"));
        return (mapper.convertLibroToLibroDTO(risultato));
    }

    public void addLibro(LibroForm libroForm) {
        Libro libro = mapper.convertLibroFormToLibro(libroForm); // creo un nuovo libro con titolo e anno

        libro.setGenere(genereRepository.findByNomeIgnoreCase(libroForm.getNomeGenere()) // setto il genere, se
                                                                                         // esistente nel DB
                .orElseThrow(() -> new RuntimeException("Genere " + libroForm.getNomeGenere() + " non trovato")));// altrimenti
                                                                                                                  // ciao

        Set<Autore> autoriDalDB = new HashSet<>(); // creo nuova Lista per ospitare uno o più autori
        for (AutoreForm autoreForm : libroForm.getListaAutori()) { // controllo se esiste già nel DB
            Autore autore = autoreRepository
                    .findByNomeIgnoreCaseAndCognomeIgnoreCaseAndDataNascita(autoreForm.getNome(),
                            autoreForm.getCognome(), autoreForm.getDataDiNascita())
                    .orElseGet(() -> autoreRepository.save(mapper.convertAutoreFormToAutore(autoreForm))); // se non
                                                                                                           // esiste lo
                                                                                                           // aggiungo,
                                                                                                           // nel DB
            autoriDalDB.add(autore);// poi lo aggiungo alla lista
        }
        libro.setAutori(autoriDalDB);// la lista la allego al libro creato

        libroRepository.save(libro); // salvo il nuovo libro nel DB ed infine piango
    }

    public void updateLibro(Integer id, LibroForm libroForm) {
        Libro libroDalDB = libroRepository.findById(id) // cerco un libro tramite id
                .orElseThrow(() -> new RuntimeException("Libro con id " + id + " non trovato"));// se non lo trova
                                                                                                // lancia eccezione
        mapper.updateLibroFromForm(libroDalDB, libroForm);// se lo trova lo aggiorna (titolo e anno)

        libroDalDB.setGenere(genereRepository.findByNomeIgnoreCase(libroForm.getNomeGenere()) // poi aggiona il genere,
                                                                                              // se esistente nel DB
                .orElseThrow(() -> new RuntimeException("Genere " + libroForm.getNomeGenere() + " non trovato")));

        Set<Autore> autoriDalDB = new HashSet<>(); // creo nuova Lista per ospitare uno o più autori
        for (AutoreForm autoreForm : libroForm.getListaAutori()) { // controllo se esiste già nel DB
            Autore autore = autoreRepository
                    .findByNomeIgnoreCaseAndCognomeIgnoreCaseAndDataNascita(autoreForm.getNome(),
                            autoreForm.getCognome(), autoreForm.getDataDiNascita())
                    .orElseGet(() -> autoreRepository.save(mapper.convertAutoreFormToAutore(autoreForm))); // se non
                                                                                                           // esiste lo
                                                                                                           // aggiungo,
                                                                                                           // nel DB
            autoriDalDB.add(autore);// poi lo aggiungo alla lista

        }
        libroDalDB.setAutori(autoriDalDB);// la lista la allego al libro creato, sostituendo la precendete

        libroRepository.save(libroDalDB);// infine lo salva

    }

    @Transactional
    public void deleteLibro(Integer id) {
        Libro libroDalDB = libroRepository.findById(id) // cerco il libro da bandire
                .orElseThrow(() -> new RuntimeException("Libro con id " + id + " non trovato"));

        copiaRepository.deleteLibroById(id); // cancello ogni sua copia

        libroDalDB.getAutori().clear(); // cancello la SUA Lista di autori, manualmente, per prassi

        libroRepository.delete(libroDalDB); // lo elimino

    }

}

/*- deleteLibro(): Prima di tutto gestire il caso in cui il libro passato dal Client non esiste.
 Poi, cancellare tutti i record dalle tabelle che hanno come foreign key l'id del Libro (Libri_Autori, Copie),
 con il parametro id associato al Libro passato dal Client.*/