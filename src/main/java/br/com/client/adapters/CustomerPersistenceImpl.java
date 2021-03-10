package br.com.client.adapters;

import br.com.client.domain.Customer;
import br.com.client.model.Client;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

public class CustomerPersistenceImpl implements CustomerPersistence {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Customer save(Customer cliente) {


            entityManager.merge(new Client());

            return null;

    }



    @Override
    public Customer find(Integer cpf) {
        try{
            Client client = entityManager.createNamedQuery(Client.CONSULTA_CLIENT_CPF, Client.class)
                    .setParameter("cpf", cpf).getSingleResult();
        } catch (NoResultException exception){
            //client nao encontrado
        }


        return null;
    }


}
