package br.com.client;

import br.com.client.returns.Error;
import br.com.client.returns.ErrorValidationResultTransform;
import br.com.client.exceptions.UnprocessableEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RestControlletExceptionHandler {


    @ExceptionHandler
    ResponseEntity<Object> handleException (final Exception exception){

        final Error error = new Error(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Erro genérico");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);

    }

    @ExceptionHandler
    ResponseEntity<Object> handleException (final UnprocessableEntityException exception){

        final Error error = exception.getError(new ErrorValidationResultTransform(exception.getHttpStatus(), "UNPROCESSABLE_ENTITY"));

        return ResponseEntity.status(exception.getHttpStatus()).contentType(MediaType.APPLICATION_JSON).body(error);

    }





}
