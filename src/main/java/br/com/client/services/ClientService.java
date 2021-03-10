package br.com.client.services;

import br.com.client.adapters.CustomerPersistence;
import br.com.client.domain.Customer;
import br.com.client.exceptions.UnprocessableEntityException;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;

@Component
public class ClientService {

    CustomerPersistence<Customer> customerPersistence;

    public void createOrUpdateCustomer(Customer customer){

        try {
            customerPersistence.save(customer);

        } catch (Exception exception){
            //TODO ADD MESSAGE AND ERROR OBJECT
            throw (UnprocessableEntityException) exception.getCause();
        }

    }

    public Customer getCustomer(String cpf){

        try {
            return customerPersistence.find(cpf);
        }catch (NoResultException exception){
            //TODO ADD MESSAGE AND ERROR OBJECT
            throw (UnprocessableEntityException) exception.getCause();
        }

    }

}
