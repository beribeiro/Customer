package br.com.client.mappers.dto;

import br.com.client.domain.Endereco;
import br.com.client.dto.EnderecoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class AddressMapper {

    public static final AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(source = "address",target = "address")
    @Mapping(source = "district", target = "district")
    @Mapping(source = "city",target = "city")
    @Mapping(source = "state", target = "state")
    @Mapping(source = "zipCode",target = "zipCode")
    public abstract Endereco mapFrom (EnderecoDto enderecoDto);

}
