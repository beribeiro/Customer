package br.com.client.services;

import br.com.client.adapters.CustomerPersistence;
import br.com.client.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public class ClientService {

    CustomerPersistence<Customer> customerPersistence;

    public void createOrUpdateCustomer(Customer customer){

        customerPersistence.save(customer);

    }

    public Customer getCustomer(String cpf){

        return customerPersistence.find(cpf);
    }

}
