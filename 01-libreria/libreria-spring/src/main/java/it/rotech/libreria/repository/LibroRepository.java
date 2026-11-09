package it.rotech.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.rotech.libreria.entity.Libro;

//dato che questa classe estende JpaRepository non è necessaria l'annotazione @Repository seguente
@Repository 
public interface LibroRepository extends JpaRepository<Libro, Integer>{
 
}
