package br.com.client.adapters;

import br.com.client.domain.Customer;
import br.com.client.mappers.domain.CustomerMapper;
import br.com.client.mappers.model.CustomerModelMapper;
import br.com.client.model.AddressModel;
import br.com.client.model.CustomerModel;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

public class CustomerPersistenceImpl implements CustomerPersistence {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Customer customer) {

        CustomerModel customerModel = CustomerMapper.INSTANCE.mapFrom(customer);

        entityManager.merge(customerModel);

    }



    @Override
    public Customer find(String cpf) {
        try{
            CustomerModel customerModel = entityManager.createNamedQuery(CustomerModel.CONSULTA_CUSTOMER_CPF, CustomerModel.class)
                    .setParameter("cpf", cpf).getSingleResult();

            return CustomerModelMapper.INSTANCE.mapFrom(customerModel);

        } catch (NoResultException exception){
            //client nao encontrado
        }


        return null;
    }


}
