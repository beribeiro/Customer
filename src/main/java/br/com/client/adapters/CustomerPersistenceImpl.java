package br.com.client.adapters;

import br.com.client.domain.Customer;
import br.com.client.mappers.domain.CustomerMapper;
import br.com.client.mappers.model.CustomerModelMapper;
import br.com.client.model.AddressModel;
import br.com.client.model.CustomerModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Optional;

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

            //final Optional<CustomerModel> customerModelOptional = Optional.ofNullable(entityManager.find(CustomerModel.class, cpf, LockModeType.PESSIMISTIC_WRITE));

            //final CustomerModel customerModel = customerModelOptional.orElse(null);

            return CustomerModelMapper.INSTANCE.mapFrom(customerModel);

        } catch (NoResultException exception){
            //client nao encontrado
        }


        return null;
    }


}
