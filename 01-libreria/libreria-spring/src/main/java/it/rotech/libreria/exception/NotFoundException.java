package it.rotech.libreria.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
    super(message);
    }
    //CIOE'??
    /*cioè, "super" chiama il costruttore della classe "madre", cioè RuntimeException e
    le passa il messaggio, così è RuntimeException a conservarlo.
    Cioè, è da qui che più tardi, nell'handler, e.getMessage() va a pescare il messaggio da restituire */ 
}