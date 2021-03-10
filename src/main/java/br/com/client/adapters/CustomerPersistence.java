package br.com.client.adapters;

import br.com.client.domain.Customer;

public interface CustomerPersistence<T extends Customer>{

    Customer save (final T cliente);

    Customer find (final String cpf);

}
