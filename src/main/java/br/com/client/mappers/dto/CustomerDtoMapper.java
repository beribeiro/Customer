package br.com.client.mappers.dto;

import br.com.client.domain.Customer;
import br.com.client.dto.ClienteDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = AddressDtoMapper.class)
public abstract class CustomerDtoMapper {

    public static final CustomerDtoMapper INSTANCE = Mappers.getMapper(CustomerDtoMapper.class);

    @Mapping(source = "name",target = "name")
    @Mapping(source = "cpf", target = "cpf")
    @Mapping(source = "enderecoDto", target = "address")
    @Mapping(target = "customerDB", ignore = true)
    public abstract Customer mapFrom (ClienteDto clienteDto);
}
