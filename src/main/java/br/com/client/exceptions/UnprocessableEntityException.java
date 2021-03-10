package br.com.client.exceptions;

import br.com.fluentvalidator.context.ValidationResult;
import br.com.fluentvalidator.exception.ValidationException;

public class UnprocessableEntityException extends ValidationException {


    private static final String UNPROCESSABLE_ENTITY_CODE = "422";

    public UnprocessableEntityException(final ValidationResult validationResult){
        super(validationResult);
    }

    public String getHttpStatus(){
        return UNPROCESSABLE_ENTITY_CODE;
    }

}
