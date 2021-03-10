package br.com.client.mappers.domain;

import br.com.client.domain.Customer;
import br.com.client.dto.ClienteDto;
import br.com.client.model.CustomerModel;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-10T15:45:17-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class CustomerMapperImpl extends CustomerMapper {

    private final AddresMapper addresMapper = Mappers.getMapper( AddresMapper.class );

    @Override
    public CustomerModel mapFrom(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerModel customerModel = new CustomerModel();

        customerModel.setName( customer.getName() );
        customerModel.setCpf( customer.getCpf() );
        customerModel.setAddressModel( addresMapper.mapFrom( customer.getAddress() ) );

        return customerModel;
    }

    @Override
    public ClienteDto mapToDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        ClienteDto clienteDto = new ClienteDto();

        clienteDto.setName( customer.getName() );
        clienteDto.setCpf( customer.getCpf() );
        clienteDto.setEnderecoDto( addresMapper.mapToDto( customer.getAddress() ) );

        return clienteDto;
    }
}
