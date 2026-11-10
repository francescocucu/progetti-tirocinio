package it.rotech.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.rotech.libreria.entity.Libro;

//dato che questa classe estende JpaRepository non è necessaria l'annotazione @Repository seguente
//@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>{
 
}



/*IL REPOSITORY: strato di accesso ai dati.
Legge, salva, e cancella righe nel database, senza logica di business: quella sta nel SERVICE, il quale usa il repository.
Il SERVICE è la mente, il REPOSITORY il braccio.
Estendendo JpaRepository<Entità, TipoId> eredita già findAll, findById, save, deleteById.
*/