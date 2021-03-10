package br.com.client.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco {

    private String address;

    private String district;

    private String city;

    private String state;

    private Integer zipCode;

}
