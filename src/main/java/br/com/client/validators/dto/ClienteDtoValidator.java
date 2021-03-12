package br.com.client.validators.dto;

import br.com.client.dto.ClienteDto;
import br.com.fluentvalidator.AbstractValidator;
import org.springframework.stereotype.Component;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.stringSizeLessThanOrEqual;

@Component
public class ClienteDtoValidator extends AbstractValidator<ClienteDto> {

    @Override
    public void rules() {

        ruleFor(ClienteDto::getName)
                .must(not(nullValue()))
                .withMessage("Favor preencher o campo nome")
                .withAttempedValue(ClienteDto::getName)
                .critical()


                .must(stringSizeLessThanOrEqual(50))
                .withMessage("Nome deve ter no máximo 50 caracteres")
                .withAttempedValue(ClienteDto::getName);

        ruleFor(ClienteDto::getCpf)
                .whenever(not(nullValue()))
                .withValidator(new CpfValidator());


    }
}
