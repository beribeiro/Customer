package br.com.client.adapters;

import br.com.client.domain.Customer;
import br.com.client.model.Address;
import br.com.client.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

public class CustomerPersistenceImpl implements CustomerPersistence {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Customer save(Customer cliente) {


        Client client = new Client("Bruno", "12345678" , new Address());

        entityManager.merge(client);

        return null;

    }



    @Override
    public Customer find(String cpf) {
        try{
            Client client = entityManager.createNamedQuery(Client.CONSULTA_CLIENT_CPF, Client.class)
                    .setParameter("cpf", cpf).getSingleResult();
        } catch (NoResultException exception){
            //client nao encontrado
        }


        return null;
    }


}
