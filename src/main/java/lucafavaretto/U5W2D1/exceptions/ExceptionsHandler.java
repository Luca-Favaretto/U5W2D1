package lucafavaretto.U5W2D1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) // 400
    public ErrorsPayload handleBadRequest(BadRequestException ex) {
        if (ex.getErrorsList() != null) {

            List<String> errorsList = ex.getErrorsList().stream().map(objectError -> objectError.getDefaultMessage()).toList();

            return new ErrorsPayloadWithList(ex.getMessage(), LocalDateTime.now(), errorsList);
        } else {
            return new ErrorsPayload(ex.getMessage(), LocalDateTime.now());
        }

    }


    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // 404
    public ErrorsPayload handleNotFound(NotFoundException ex) {
        return new ErrorsPayload(ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(Exception.class)
    // Tutti gli altri tipi di eccezioni (come ad es bug nel codice) verranno gestiti da questo metodo
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500
    public ErrorsPayload handleGenericErrors(Exception ex) {
        ex.printStackTrace();
        // N.B. non dimentichiamoci che è ESTREMAMENTE UTILE tenere traccia di chi ha causato l'errore per poterlo fixare
        return new ErrorsPayload("Problema lato server! Prometto che lo fixeremo presto!", LocalDateTime.now());
    }
}
