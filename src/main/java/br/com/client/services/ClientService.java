package br.com.client.services;

import br.com.client.adapters.CustomerPersistence;
import br.com.client.domain.Customer;
import br.com.client.exceptions.UnprocessableEntityException;
import br.com.fluentvalidator.context.Error;
import br.com.fluentvalidator.context.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.Collections;

@Component
@Transactional
public class ClientService {


    @Autowired
    CustomerPersistence<Customer> customerPersistence;

    public void createOrUpdateCustomer(Customer customer){

        customerPersistence.save(customer);

    }

    public Customer getCustomer(String cpf){

        return customerPersistence.findByCpf(cpf);

    }

}
