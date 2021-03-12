package br.com.client.mappers.model;

import br.com.client.domain.Customer;
import br.com.client.model.CustomerModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = AddressModelMapper.class)
public abstract class CustomerModelMapper {

    public static final CustomerModelMapper INSTANCE = Mappers.getMapper(CustomerModelMapper.class);

    @Mapping(source = "name",target = "name")
    @Mapping(source = "cpf", target = "cpf")
    @Mapping(source = "addressModel", target = "address")
    @Mapping(target = "customerDB", ignore = true)
    public abstract Customer mapFrom (CustomerModel customerModel);
}
