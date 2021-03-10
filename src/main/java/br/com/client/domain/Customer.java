package br.com.client.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

    private String nome;

    private Integer cpf;

    private Endereco endereco;

    private Customer clienteDB;
}
