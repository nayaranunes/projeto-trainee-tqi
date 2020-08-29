package br.com.cipher.loans.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {RequestException.class})
    public ResponseEntity<Object> handleApiRequestException(RequestException e) {
        //Payload
        HttpStatus unprocessableEntity = HttpStatus.UNPROCESSABLE_ENTITY; //error de ngc 422
        BusinessException apiException = new BusinessException(
                e.getMessage(),
                unprocessableEntity,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, unprocessableEntity);
    }
}
