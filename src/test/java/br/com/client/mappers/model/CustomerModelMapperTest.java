package br.com.client.mappers.model;

import br.com.client.domain.Customer;
import br.com.client.model.CustomerModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerModelMapperTest {

    @Test
    public void successTest(){
        CustomerModel customerModel = new CustomerModel();

        customerModel.setName("João");
        customerModel.setCpf("124.125.126-78");

        Customer customer = CustomerModelMapper.INSTANCE.mapFrom(customerModel);

        assertEquals(customerModel.getName(), customer.getName());
        assertEquals(customerModel.getCpf(), customer.getCpf());

    }
}
