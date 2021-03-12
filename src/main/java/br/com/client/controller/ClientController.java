package br.com.client.controller;

import br.com.client.domain.Customer;
import br.com.client.dto.ClienteDto;
import br.com.client.exceptions.UnprocessableEntityException;
import br.com.client.mappers.domain.CustomerMapper;
import br.com.client.mappers.dto.CustomerDtoMapper;
import br.com.client.services.ClientService;
import br.com.client.validators.dto.ClienteDtoValidator;
import br.com.client.validators.dto.CpfValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class ClientController {

    @Autowired
    private ClientService service;

    @Autowired
    private ClienteDtoValidator clienteDtoValidator;

    @Autowired
    private CpfValidator cpfValidator;

    @PostMapping(value = "/register")
    public ResponseEntity<Object> customer(@RequestBody final ClienteDto clienteDto){

        clienteDtoValidator.validate(clienteDto).isInvalidThrow(UnprocessableEntityException.class);

        Customer customer = CustomerDtoMapper.INSTANCE.mapFrom(clienteDto);

        service.createOrUpdateCustomer(customer);

        return ResponseEntity.status(HttpStatus.OK).body(clienteDto);
    }
    
    @GetMapping(value = "/{cpf}")
    public ResponseEntity<Object> getCustomer(@PathVariable String cpf){

        cpfValidator.validate(cpf).isInvalidThrow(UnprocessableEntityException.class);

        Customer customer = service.getCustomer(cpf);

        ClienteDto clienteDto = CustomerMapper.INSTANCE.mapToDto(customer);

        return ResponseEntity.status(HttpStatus.OK).body(clienteDto);
    }

}
