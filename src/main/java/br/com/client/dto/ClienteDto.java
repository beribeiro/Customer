package br.com.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("address")
    private EnderecoDto enderecoDto;

}
