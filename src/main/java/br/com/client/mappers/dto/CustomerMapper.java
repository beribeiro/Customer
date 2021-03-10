package br.com.client.mappers.dto;

import br.com.client.domain.Customer;
import br.com.client.dto.ClienteDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = AddressMapper.class)
public abstract class CustomerMapper {

    public static final CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "name",target = "name")
    @Mapping(source = "cpf", target = "cpf")
    @Mapping(source = "enderecoDto", target = "address")
    @Mapping(target = "customerDB", ignore = true)
    public abstract Customer mapFrom (ClienteDto clienteDto);
}
