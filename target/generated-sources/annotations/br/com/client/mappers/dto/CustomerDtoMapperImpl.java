package br.com.client.mappers.dto;

import br.com.client.domain.Customer;
import br.com.client.dto.ClienteDto;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-10T01:51:10-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class CustomerDtoMapperImpl extends CustomerDtoMapper {

    private final AddressDtoMapper addressDtoMapper = Mappers.getMapper( AddressDtoMapper.class );

    @Override
    public Customer mapFrom(ClienteDto clienteDto) {
        if ( clienteDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( clienteDto.getName() );
        customer.setCpf( clienteDto.getCpf() );
        customer.setAddress( addressDtoMapper.mapFrom( clienteDto.getEnderecoDto() ) );

        return customer;
    }
}
