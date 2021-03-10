package br.com.client.mappers.dto;

import br.com.client.domain.Endereco;
import br.com.client.dto.EnderecoDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressModelDtoMapperTest {

    @Test
    public void successTest(){
        EnderecoDto enderecoDto = new EnderecoDto();

        enderecoDto.setAddress("Rua exemplo");
        enderecoDto.setDistrict("Mooca");
        enderecoDto.setCity("São Paulo");
        enderecoDto.setState("SP");
        enderecoDto.setZipCode("1234567");

        Endereco endereco = AddressDtoMapper.INSTANCE.mapFrom(enderecoDto);

        assertEquals(endereco.getAddress(), endereco.getAddress());
        assertEquals(endereco.getDistrict(), endereco.getDistrict());
        assertEquals(endereco.getCity(), endereco.getCity());
        assertEquals(endereco.getState(), endereco.getState());
        assertEquals(endereco.getZipCode(), endereco.getZipCode());

    }

}
