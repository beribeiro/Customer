package br.com.client.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDto {

    private String nome;

    private String cpf;

    private EnderecoDto enderecoDto;

}
