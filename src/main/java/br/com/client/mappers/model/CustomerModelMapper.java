package br.com.client.mappers.model;

import br.com.client.domain.Customer;
import br.com.client.model.CustomerModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CustomerModelMapper {

    public static final CustomerModelMapper INSTANCE = Mappers.getMapper(CustomerModelMapper.class);

    @Mapping(source = "name",target = "name")
    @Mapping(source = "cpf", target = "cpf")
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "customerDB", ignore = true)
    public abstract Customer mapFrom (CustomerModel customerModel);
}
