package br.com.client.mappers.dto;

import br.com.client.domain.Customer;
import br.com.client.dto.ClienteDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerDtoMapperTest {

    @Test
    public void successTest(){
        ClienteDto clienteDto = new ClienteDto();

        clienteDto.setName("João");
        clienteDto.setCpf("124.125.126-78");

        Customer customer = CustomerDtoMapper.INSTANCE.mapFrom(clienteDto);

        assertEquals(clienteDto.getName(), customer.getName());
        assertEquals(clienteDto.getCpf(), customer.getCpf());

    }
}
