package ec.com.sofka.exceptions;

public class MovementNotFoundException  extends RuntimeException{
    public MovementNotFoundException(String message) {
        super(message);
    }
}
