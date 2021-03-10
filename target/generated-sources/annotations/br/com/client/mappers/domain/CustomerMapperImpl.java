package br.com.client.mappers.domain;

import br.com.client.domain.Customer;
import br.com.client.model.CustomerModel;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-10T11:32:07-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class CustomerMapperImpl extends CustomerMapper {

    @Override
    public CustomerModel mapFrom(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerModel customerModel = new CustomerModel();

        customerModel.setName( customer.getName() );
        customerModel.setCpf( customer.getCpf() );

        return customerModel;
    }
}
