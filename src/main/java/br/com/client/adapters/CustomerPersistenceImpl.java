package br.com.client.adapters;

import br.com.client.domain.Customer;
import br.com.client.exceptions.UnprocessableEntityException;
import br.com.client.mappers.domain.CustomerMapper;
import br.com.client.mappers.model.CustomerModelMapper;
import br.com.client.model.CustomerModel;
import br.com.fluentvalidator.context.Error;
import br.com.fluentvalidator.context.ValidationResult;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Collections;

@Repository
public class CustomerPersistenceImpl implements CustomerPersistence<Customer> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Customer customer) {

        CustomerModel customerModel = CustomerMapper.INSTANCE.mapFrom(customer);

        entityManager.merge(customerModel);

    }



    @Override
    public Customer findByCpf(String cpf) {
        try{
            CustomerModel customerModel = entityManager.createNamedQuery(CustomerModel.CONSULTA_CUSTOMER_CPF, CustomerModel.class)
                    .setParameter("cpf", cpf).getSingleResult();

            return CustomerModelMapper.INSTANCE.mapFrom(customerModel);

        } catch (NoResultException exception){
            throw new UnprocessableEntityException(ValidationResult.fail(Collections.singleton(Error.create("customer", "Customer not found", "422", cpf))));
        }
    }
}
