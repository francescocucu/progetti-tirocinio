package it.rotech.libreria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.rotech.libreria.dto.CopiaDTO;
import it.rotech.libreria.dto.CopiaForm;
import it.rotech.libreria.entity.CasaEditrice;
import it.rotech.libreria.entity.Copia;
import it.rotech.libreria.entity.Genere;
import it.rotech.libreria.entity.Libro;
import it.rotech.libreria.repository.CasaEditriceRepository;
import it.rotech.libreria.repository.CopiaRepository;
import it.rotech.libreria.repository.LibroRepository;
import it.rotech.libreria.utility.Mapper;

@Service
public class CopiaService {

    private final CopiaRepository copiaRepository;
    private final LibroRepository libroRepository;
    private final CasaEditriceRepository casaEditriceRepository;
    private final Mapper mapper;

    public CopiaService(CopiaRepository copiaRepository, LibroRepository libroRepository,
            CasaEditriceRepository casaEditriceRepository, Mapper mapper) {
        this.copiaRepository = copiaRepository;
        this.libroRepository = libroRepository;
        this.casaEditriceRepository = casaEditriceRepository;
        this.mapper = mapper;
    }

    public List<CopiaDTO> findAll() {
        List<Copia> risultato = copiaRepository.findAll();
        List<CopiaDTO> copieDTO = new ArrayList<>();
        for (Copia copia : risultato) {
            copieDTO.add(mapper.convertCopiaToCopiaDTO(copia));
        }
        return copieDTO;
    }

    public CopiaDTO findById(Integer id) {
        Copia risultato = copiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("oggetto Copia con id " + id + " non trovato"));
        return mapper.convertCopiaToCopiaDTO(risultato);
    }

    public void addCopia(CopiaForm copiaForm) {

        Copia copia = mapper.convertCopiaFormToCopia(copiaForm);

        Libro libro = libroRepository.findById(copiaForm.getLibroId())
                .orElseThrow(() -> new RuntimeException("Libro con id " + copiaForm.getLibroId() + " non trovato"));

        CasaEditrice casaEditrice = casaEditriceRepository.findById(copiaForm.getCasaEditriceId())
                .orElseThrow(() -> new RuntimeException(
                        "Casa editrice con id " + copiaForm.getCasaEditriceId() + " non trovata"));

        copia.setLibro(libro);
        copia.setCasaEditrice(casaEditrice);

        copiaRepository.save(copia);

    }

    public void updateCopia(Integer id, CopiaForm copiaForm) {
        Copia risultato = copiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("oggetto Copia con id " + id + " non trovato"));

        risultato.setNumeroCopie(copiaForm.getNumeroCopie());

        Libro libro = libroRepository.findById(copiaForm.getLibroId())
                .orElseThrow(() -> new RuntimeException("Libro con id " + copiaForm.getLibroId() + " non trovato"));

        CasaEditrice casaEditrice = casaEditriceRepository.findById(copiaForm.getCasaEditriceId())
                .orElseThrow(() -> new RuntimeException(
                        "Casa editrice con id " + copiaForm.getCasaEditriceId() + " non trovata"));

        risultato.setLibro(libro);
        risultato.setCasaEditrice(casaEditrice);

        copiaRepository.save(risultato);

    }

    public void deleteCopia (Integer id) {
        Copia risultato = copiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("oggetto Copia con id " + id + " non trovato"));
                copiaRepository.delete(risultato);

    }

}// end class
