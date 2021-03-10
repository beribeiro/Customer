package br.com.client.validators.dto;

import br.com.client.dto.ClienteDto;
import br.com.fluentvalidator.AbstractValidator;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.*;


public class ClienteDtoValidator extends AbstractValidator<ClienteDto> {

    public static final String REGEX_CPF = "^([0-9]{3}\\.?){3}-?[0-9]{2}$";
    @Override
    public void rules() {

        ruleFor(ClienteDto::getNome)
                .must(not(nullValue()))
                .withMessage("Favor preencher o campo nome")
                .withAttempedValue(ClienteDto::getNome)
                .critical()


                .must(stringSizeLessThanOrEqual(10))
                .withMessage("Nome deve ter no máximo 50 caracteres")
                .withAttempedValue(ClienteDto::getNome);

        ruleFor(ClienteDto::getCpf)
                .must(not(nullValue()))
                .withMessage("Favor preencher o campo Cpf")
                .withAttempedValue(ClienteDto::getCpf)
                .critical()

                .must(stringMatches(REGEX_CPF))
                .withMessage("CPF inválido")
                .withAttempedValue(ClienteDto::getCpf);





    }
}
