package br.com.client.validators.dto;

import br.com.fluentvalidator.AbstractValidator;
import org.springframework.stereotype.Component;

import static br.com.client.utils.Regex.REGEX_CPF;
import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.stringMatches;

@Component
public class CpfValidator extends AbstractValidator<String> {

    @Override
    public void rules() {

        ruleFor(cpf -> cpf)
                .must(not(nullValue()))
                .withMessage("Favor preencher o campo Cpf")
                .withAttempedValue(cpf-> cpf)
                .withFieldName("cpf")
                .critical()

                .must(stringMatches(REGEX_CPF))
                .withMessage("CPF inválido")
                .withAttempedValue(cpf-> cpf)
                .withFieldName("cpf");

    }
}
