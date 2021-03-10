package br.com.client.adapters;

import br.com.client.domain.Customer;
import br.com.client.model.AddressModel;
import br.com.client.model.CustomerModel;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

public class CustomerPersistenceImpl implements CustomerPersistence {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Customer save(Customer cliente) {


        CustomerModel client = new CustomerModel("Bruno", "12345678" , new AddressModel());

        entityManager.merge(client);

        return null;

    }



    @Override
    public Customer find(String cpf) {
        try{
            CustomerModel client = entityManager.createNamedQuery(CustomerModel.CONSULTA_CLIENT_CPF, CustomerModel.class)
                    .setParameter("cpf", cpf).getSingleResult();
        } catch (NoResultException exception){
            //client nao encontrado
        }


        return null;
    }


}
