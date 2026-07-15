package org.generation.e_tech_mexico.excepcion;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Manejar errores específicos de recursos no encontrados (404)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> manejarResourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
        ErrorDetalles detallesError = new ErrorDetalles(
                new Date(),
                exception.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(detallesError, HttpStatus.NOT_FOUND);
    }

    // Manejar cualquier otro error global (500) para que no rompa el servidor de forma inesperada
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> manejarGlobalException(Exception exception, WebRequest request) {
        ErrorDetalles detallesError = new ErrorDetalles(
                new Date(),
                "Ocurrió un error interno en el servidor: " + exception.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(detallesError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}