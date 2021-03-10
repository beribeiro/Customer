package br.com.client.mappers.domain;

import br.com.client.domain.Customer;
import br.com.client.model.CustomerModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CustomerMapper {

    public static final CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "name",target = "name")
    @Mapping(source = "cpf", target = "cpf")
    @Mapping(target = "addressModel", ignore = true)

    public abstract CustomerModel mapFrom (Customer customer);
}
