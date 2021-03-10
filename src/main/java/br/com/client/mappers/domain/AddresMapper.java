package br.com.client.mappers.domain;

import br.com.client.domain.Customer;
import br.com.client.domain.Endereco;
import br.com.client.dto.ClienteDto;
import br.com.client.dto.EnderecoDto;
import br.com.client.model.AddressModel;
import br.com.client.model.CustomerModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import javax.persistence.Column;

@Mapper
public abstract class AddresMapper {

    public static final CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "address",target = "address")
    @Mapping(source = "district",target = "district")
    @Mapping(source = "city",target = "city")
    @Mapping(source = "state",target = "state")
    @Mapping(source = "zipCode",target = "zipCode")
    public abstract AddressModel mapFrom (Endereco endereco);

    @Mapping(source = "address",target = "address")
    @Mapping(source = "district",target = "district")
    @Mapping(source = "city",target = "city")
    @Mapping(source = "state",target = "state")
    @Mapping(source = "zipCode",target = "zipCode")
    public abstract EnderecoDto mapToDto (Endereco endereco);
}
