package br.com.client.mappers;

import br.com.client.domain.Customer;
import br.com.client.dto.ClienteDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CustomerMapper {

    public static final CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "nome", target = "nome")
    public abstract Customer mapFrom (ClienteDto clienteDto);
}
