package it.rotech.libreria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
// Questa classe è il centralino delle eccezioni: intercetta quelle lanciate
// durante le richieste a tutti i controller
// e le trasforma in risposte HTTP con il codice giusto + i messaggi di errore
// scritti nei service
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFound(NotFoundException e) { // "quando qualcuno lancia NotFoundException me
                                                                        // la magno"
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); // e restituisco un codice di errore
                                                                                 // http
                                                                                 // + il messaggio e.getMessage()
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<String> handleConflict(ConflictException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBadRequest(BadRequestException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }



}//vale per tutti, sono metodi generici che possono essere usati per ogni service
