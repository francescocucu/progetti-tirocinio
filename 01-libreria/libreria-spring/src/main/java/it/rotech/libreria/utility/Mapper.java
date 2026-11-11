package it.rotech.libreria.utility;

import org.springframework.stereotype.Component;

import it.rotech.libreria.dto.AutoreDTO;
import it.rotech.libreria.dto.CasaEditriceDTO;
import it.rotech.libreria.dto.CopiaDTO;
import it.rotech.libreria.dto.GenereDTO;
import it.rotech.libreria.dto.LibroDTO;
import it.rotech.libreria.dto.LibroForm;
import it.rotech.libreria.entity.Autore;
import it.rotech.libreria.entity.CasaEditrice;
import it.rotech.libreria.entity.Copia;
import it.rotech.libreria.entity.Genere;
import it.rotech.libreria.entity.Libro;

@Component
public class Mapper {

    // costruttore di Mapper
    public Mapper() {
    }

    public Autore covertAutoreDTOToAutore(AutoreDTO autoreDTO) {
        Autore autore = new Autore();
        autore.setNome(autoreDTO.getNome());
        autore.setCognome(autoreDTO.getCognome());
        autore.setDataNascita(autoreDTO.getDataNascita());
        autore.setNazionalita(autoreDTO.getNazionalita());
        return autore;
    }

    public AutoreDTO convertAutoreToAutoreDTO(Autore autore) {
        AutoreDTO autoreDTO = new AutoreDTO();
        autoreDTO.setId(autore.getId());
        autoreDTO.setNome(autore.getNome());
        autoreDTO.setCognome(autore.getCognome());
        autoreDTO.setDataNascita(autore.getDataNascita());
        autoreDTO.setNazionalita(autore.getNazionalita());
        return autoreDTO;
    }

    public CasaEditrice convertCasaEditriceDTOToCasaEditrice(CasaEditriceDTO casaEditriceDTO) {
        CasaEditrice casaEditrice = new CasaEditrice();
        casaEditrice.setNome(casaEditriceDTO.getNome());
        return casaEditrice;
    }

    public CasaEditriceDTO convCasaEditriceToCasaEditriceDTO(CasaEditrice casaEditrice) {
        CasaEditriceDTO casaEditriceDTO = new CasaEditriceDTO();
        casaEditriceDTO.setId(casaEditrice.getId());
        casaEditriceDTO.setNome(casaEditrice.getNome());
        return casaEditriceDTO;
    }

    public Copia convertCopiaDTOToCopia(CopiaDTO copiaDTO) {
        Copia copia = new Copia();
        copia.setNumeroCopie(copiaDTO.getNumeroCopie());
        copia.setCasaEditrice(convertCasaEditriceDTOToCasaEditrice(copiaDTO.getCasaEditrice()));
        // copia.setLibro(convertLibroForm5ToLibro(copiaDTO.getLibro()));
        return copia;
    }

    public CopiaDTO convertCopiaToCopiaDTO(Copia copia) {
        CopiaDTO copiaDTO = new CopiaDTO();
        copiaDTO.setId(copia.getId());
        copiaDTO.setNumeroCopie(copia.getNumeroCopie());
        copiaDTO.setCasaEditrice(convCasaEditriceToCasaEditriceDTO(copia.getCasaEditrice()));
       // copiaDTO.setLibro(convertLibroToLibroDTO(copia.getLibro()));
        return copiaDTO;
    }

    public Genere convertGenereDTOToGenere(GenereDTO genereDTO) {
        Genere genere = new Genere();
        genere.setNome(genereDTO.getNome());
        return genere;
    }

    public GenereDTO convertGenereToGenereDTO(Genere genere) {
        GenereDTO genereDTO = new GenereDTO();
        genereDTO.setId(genere.getId());
        genereDTO.setNome(genere.getNome());
        return genereDTO;
    }

    // Il genere lo aggiunge il service, nel metodo create
    public Libro convertLibroFormToLibro(LibroForm libroForm) {
        Libro libro = new Libro();
        libro.setTitolo(libroForm.getTitolo());
        libro.setAnno(libroForm.getAnno());
        return libro;
    }

    public LibroDTO convertLibroToLibroForm(Libro libro) {
        LibroDTO libroDTO = new LibroDTO();
        libroDTO.setId(libro.getId());
        libroDTO.setTitolo(libro.getTitolo());
        libroDTO.setAnno(libro.getAnno());
        libroDTO.setGenere(convertGenereToGenereDTO(libro.getGenere()));
        return libroDTO;
    }

    public void updateLibroFromForm(Libro libro, LibroForm libroForm) {
        libro.setTitolo(libroForm.getTitolo());
        libro.setAnno(libroForm.getAnno());
    }

}
