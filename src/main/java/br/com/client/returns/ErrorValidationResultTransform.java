package br.com.client.returns;

import br.com.fluentvalidator.context.ValidationResult;
import br.com.fluentvalidator.transform.ValidationResultTransform;
import org.springframework.http.HttpStatus;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ErrorValidationResultTransform implements ValidationResultTransform<Error> {

    private final String httpStatus;

    private final String message;

    public ErrorValidationResultTransform(final HttpStatus httpStatus, final String message){
        this.httpStatus = String.valueOf(httpStatus.value());
        this.message = message;
    }


    @Override
    public Error transform(ValidationResult validationResult) {
        final List<FieldError> errors = new LinkedList<>();
        for (final br.com.fluentvalidator.context.Error error : validationResult.getErrors()){
            errors.add(new FieldError(error.getField(), error.getMessage(), Optional.ofNullable(error.getAttemptedValue()).orElse("null").toString()));
        }

        return new Error(httpStatus, message, errors);
    }
}
