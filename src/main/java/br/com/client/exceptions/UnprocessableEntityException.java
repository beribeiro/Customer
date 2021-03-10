package br.com.client.exceptions;

import br.com.client.returns.Error;
import br.com.fluentvalidator.context.ValidationResult;
import br.com.fluentvalidator.exception.ValidationException;
import br.com.fluentvalidator.transform.ValidationResultTransform;
import org.springframework.http.HttpStatus;

public class UnprocessableEntityException extends ValidationException {


    public UnprocessableEntityException(final ValidationResult validationResult){
        super(validationResult);
    }

    public HttpStatus getHttpStatus(){
        return HttpStatus.UNPROCESSABLE_ENTITY;
    }

    public Error getError(final ValidationResultTransform<Error> transformValidationResult){
        return transformValidationResult.transform(getValidationResult());

    }

}
