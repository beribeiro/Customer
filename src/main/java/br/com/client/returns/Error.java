package br.com.client.returns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.FieldError;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
public class Error extends Object{

    private String codigo;

    private String message;

    private Collection<FieldError> fields;

    public Error(final String codigo, final String message){
        this.codigo = codigo;
        this.message = message;
    }

}
