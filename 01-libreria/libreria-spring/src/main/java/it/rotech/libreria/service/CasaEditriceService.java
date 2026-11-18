package it.rotech.libreria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.rotech.libreria.dto.CasaEditriceDTO;
import it.rotech.libreria.dto.CasaEditriceForm;
import it.rotech.libreria.dto.GenereDTO;
import it.rotech.libreria.entity.CasaEditrice;
import it.rotech.libreria.entity.Copia;
import it.rotech.libreria.entity.Genere;
import it.rotech.libreria.entity.Libro;
import it.rotech.libreria.repository.CasaEditriceRepository;
import it.rotech.libreria.repository.CopiaRepository;
import it.rotech.libreria.utility.Mapper;

@Service
public class CasaEditriceService {

    private final Mapper mapper;
    private final CasaEditriceRepository casaEditriceRepository;
    private final CopiaRepository copiaRepository;

    public CasaEditriceService(Mapper mapper, CasaEditriceRepository casaEditriceRepository,
            CopiaRepository copiaRepository) {
        this.mapper = mapper;
        this.casaEditriceRepository = casaEditriceRepository;
        this.copiaRepository = copiaRepository;
    }

    public List<CasaEditriceDTO> findAll() {
        List<CasaEditrice> risultato = casaEditriceRepository.findAll();
        List<CasaEditriceDTO> risultatoDTO = new ArrayList<>();
        for (CasaEditrice casaEditrice : risultato) {
            risultatoDTO.add(mapper.convertCasaEditriceToCasaEditriceDTO(casaEditrice));
        }
        return risultatoDTO;
    }

    public CasaEditriceDTO findById(Integer id) {
        CasaEditrice risultato = casaEditriceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Casa editrice con id " + id + " non trovata"));
        return mapper.convertCasaEditriceToCasaEditriceDTO(risultato);
    }

    public void addCasaEditrice(CasaEditriceForm casaEditriceForm) {
        boolean risultato = casaEditriceRepository.existsByNomeIgnoreCase(casaEditriceForm.getNome());
               
        if (risultato == true) {
            throw new RuntimeException("Casa editrice '" + casaEditriceForm.getNome() + "' già presente");
        }
        CasaEditrice entity = new CasaEditrice(casaEditriceForm.getNome());

        casaEditriceRepository.save(entity);
    }

    public void updateCasaEditrice(Integer id, CasaEditriceForm casaEditriceForm) {
        CasaEditrice risultato = casaEditriceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Casa editrice con id " + id + " non trovata"));

        // controllo che il nome nuovo non sia già presente
        casaEditriceRepository.findByNomeIgnoreCase(casaEditriceForm.getNome())
                .ifPresent(casaTrovataDalFindBy -> {
                    if (!casaTrovataDalFindBy.getId().equals(id)) { // mi chiedo se il nome trovato uguale sia
                                                                    // dell'attuale entity che sto aggiornando. Se sì
                                                                    // tutto bene, altrimenti lancio eccezione
                        throw new RuntimeException("Casa editrice '" + casaEditriceForm.getNome() + "' già presente");
                    }
                });
        risultato.setNome(casaEditriceForm.getNome());
        casaEditriceRepository.save(risultato);

    }

    public void deleteCasaEditrice(Integer id) {
        CasaEditrice risultato = casaEditriceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Casa editrice con id " + id + " non trovata"));

        List<Copia> copieTrovate = copiaRepository.findAll();
        for (Copia copia : copieTrovate) {
            if (copia.getCasaEditrice().getId().equals(id)) {
                throw new RuntimeException(
                        "Attenzione, impossibile cancellare casa editrice: copie collegate");
            }
        }

        casaEditriceRepository.delete(risultato);

    }

}// end class
