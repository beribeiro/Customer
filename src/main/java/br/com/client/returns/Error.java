package br.com.client.returns;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class Error {

    private String codigo;

    private String message;

    private Collection<FieldError> fields;

    public Error(final String codigo, final String message){
        this.codigo = codigo;
        this.message = message;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
