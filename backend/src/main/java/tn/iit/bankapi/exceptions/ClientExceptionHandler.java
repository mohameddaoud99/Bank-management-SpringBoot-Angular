package tn.iit.bankapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ClientExceptionHandler {

    @ExceptionHandler(value = {ClientNotFoundException.class})
    public ResponseEntity<Object> handleClientNotFoundException
            (ClientNotFoundException clientNotFoundException)
    {
        ClientException productException = new ClientException(
                clientNotFoundException.getMessage(),
                clientNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(productException, HttpStatus.NOT_FOUND);
    }


}
