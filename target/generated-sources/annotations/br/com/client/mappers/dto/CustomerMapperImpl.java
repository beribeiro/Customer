package br.com.client.mappers.dto;

import br.com.client.domain.Customer;
import br.com.client.dto.ClienteDto;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-09T23:20:12-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class CustomerMapperImpl extends CustomerMapper {

    private final AddressMapper addressMapper = Mappers.getMapper( AddressMapper.class );

    @Override
    public Customer mapFrom(ClienteDto clienteDto) {
        if ( clienteDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( clienteDto.getName() );
        customer.setCpf( clienteDto.getCpf() );
        customer.setAddress( addressMapper.mapFrom( clienteDto.getEnderecoDto() ) );

        return customer;
    }
}
