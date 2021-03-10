package br.com.client.mappers.domain;

import br.com.client.domain.Customer;
import br.com.client.dto.ClienteDto;
import br.com.client.mappers.dto.CustomerDtoMapper;
import br.com.client.model.CustomerModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerMapperTest {

    @Test
    public void successTest(){
        Customer customer = new Customer();

        customer.setName("João");
        customer.setCpf("124.125.126-78");

        CustomerModel customerModel = CustomerMapper.INSTANCE.mapFrom(customer);

        assertEquals(customer.getName(), customerModel.getName());
        assertEquals(customer.getCpf(), customerModel.getCpf());

    }
}
