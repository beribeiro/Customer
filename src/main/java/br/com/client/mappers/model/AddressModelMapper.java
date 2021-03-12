package br.com.client.mappers.model;

import br.com.client.domain.Endereco;
import br.com.client.dto.EnderecoDto;
import br.com.client.model.AddressModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import javax.persistence.Column;

@Mapper
public abstract class AddressModelMapper {

    public static final AddressModelMapper INSTANCE = Mappers.getMapper(AddressModelMapper.class);

    @Mapping(source = "address",target = "address")
    @Mapping(source = "district", target = "district")
    @Mapping(source = "city",target = "city")
    @Mapping(source = "state", target = "state")
    @Mapping(source = "zipCode",target = "zipCode")
    public abstract Endereco mapFrom (AddressModel addressModel);

}
