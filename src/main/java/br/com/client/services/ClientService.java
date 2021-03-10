package br.com.client.services;

import br.com.client.adapters.CustomerPersistence;
import br.com.client.domain.Customer;
import br.com.client.exceptions.UnprocessableEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

@Component
@Transactional
public class ClientService {


    @Autowired
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
            return customerPersistence.findByCpf(cpf);
        }catch (NoResultException exception){
            //TODO ADD MESSAGE AND ERROR OBJECT
            throw (UnprocessableEntityException) exception.getCause();
        }

    }

}
