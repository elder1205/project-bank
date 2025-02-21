package ec.com.sofka;

import ec.com.sofka.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountNotFound.class)
    public ResponseEntity<Map<String,String>> handleCuentaNoEncontrada(AccountNotFound ex) {
        Map<String,String> error = new HashMap<>();
        error.put("error",ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(CustomerNotFound.class)
    public ResponseEntity<Map<String,String>> handleCustomerNotFound(CustomerNotFound ex) {
        Map<String,String> error = new HashMap<>();
        error.put("error",ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<Map<String,String>> handleInsufficientBalance(InsufficientBalanceException ex) {
        Map<String,String> error = new HashMap<>();
        error.put("error",ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(DateRangeException.class)
    public ResponseEntity<Map<String,String>> handleDateRangeException(DateRangeException ex) {
        Map<String,String> error = new HashMap<>();
        error.put("error",ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(NumberAccountNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleNumberAccountNotFound(NumberAccountNotFoundException ex) {
        Map<String,String> error = new HashMap<>();
        error.put("error",ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MovementNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleMovementNotFound(MovementNotFoundException ex) {
        Map<String,String> error = new HashMap<>();
        error.put("error",ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MovementException.class)
    public ResponseEntity<Map<String,String>> handleMovement(MovementException ex) {
        Map<String,String> error = new HashMap<>();
        error.put("error",ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(IdentificationException.class)
    public ResponseEntity<Map<String,String>> handleIdentificationException(IdentificationException ex) {
        Map<String,String> error = new HashMap<>();
        error.put("error",ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        // Capturar errores de validación
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
    }
}

