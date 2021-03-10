package br.com.client.mappers.domain;

import br.com.client.domain.Customer;
import br.com.client.dto.ClienteDto;
import br.com.client.mappers.dto.AddressDtoMapper;
import br.com.client.model.CustomerModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = AddresMapper.class)
public abstract class CustomerMapper {

    public static final CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "name",target = "name")
    @Mapping(source = "cpf", target = "cpf")
    @Mapping(source = "address", target = "addressModel")
    public abstract CustomerModel mapFrom (Customer customer);

    @Mapping(source = "name",target = "name")
    @Mapping(source = "cpf", target = "cpf")
    @Mapping(source = "address", target = "enderecoDto")

    public abstract ClienteDto mapToDto (Customer customer);
}
