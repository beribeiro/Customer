package br.com.client.mappers.model;

import br.com.client.domain.Customer;
import br.com.client.model.CustomerModel;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-12T20:02:38-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class CustomerModelMapperImpl extends CustomerModelMapper {

    private final AddressModelMapper addressModelMapper = Mappers.getMapper( AddressModelMapper.class );

    @Override
    public Customer mapFrom(CustomerModel customerModel) {
        if ( customerModel == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( customerModel.getName() );
        customer.setCpf( customerModel.getCpf() );
        customer.setAddress( addressModelMapper.mapFrom( customerModel.getAddressModel() ) );

        return customer;
    }
}