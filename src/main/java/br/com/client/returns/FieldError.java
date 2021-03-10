package br.com.client.returns;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = NON_NULL)
public class FieldError {

    private String campo;

    private String mensagem;

    private String valor;

}
