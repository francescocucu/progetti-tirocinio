package it.rotech.libreria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import it.rotech.libreria.dto.LibroDTO;
import it.rotech.libreria.entity.Libro;
import it.rotech.libreria.repository.LibroRepository;
import it.rotech.libreria.utility.Mapper;

@Service 
public class LibroService {

    private final LibroRepository libroRepository;
    private final Mapper mapper;

    public LibroService (LibroRepository libroRepository, Mapper mapper){
        this.libroRepository = libroRepository;
        this.mapper = mapper;
    }

    public List <LibroDTO> findAll(){
        List <Libro> risultato = libroRepository.findAll();
        List <LibroDTO> risultatoDTO = new ArrayList<>();
        for (Libro libro : risultato){
            risultatoDTO.add(mapper.convertLibroToLibroDTO(libro));
            }
        return risultatoDTO;
        }
        
    public LibroDTO findById (Integer id){
        Libro risultato = libroRepository.findById(id).orElseThrow(()-> new RuntimeException("Libro con id "+ id + " non trovato"));
        return (mapper.convertLibroToLibroDTO(risultato));
    }

    public void addLibro (LibroDTO libroDTO){
        libroRepository.save((mapper.convertLibroDTOToLibro(libroDTO)));
               
    }
        
    public void updateLibro (Integer id, LibroDTO libroDTO) {
        
        
    }
      
 
}
