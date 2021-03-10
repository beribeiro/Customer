package br.com.client.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

    private String name;

    private String cpf;

    private Endereco address;

    private Customer customerDB;
}
