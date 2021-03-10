package br.com.client.controller;

import br.com.client.dto.ClienteDto;
import br.com.client.exceptions.UnprocessableEntityException;
import br.com.client.services.ClientService;
import br.com.client.validators.dto.ClienteDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping(value = "client")
public class ClientController {

    @Autowired
    private ClientService service;

    @Autowired
    private ClienteDtoValidator clienteDtoValidator;

    @PostMapping
    public ResponseEntity<Object> customer(@RequestBody final ClienteDto clienteDto){

        clienteDtoValidator.validate(clienteDto).isInvalidThrow(UnprocessableEntityException.class);

        return ResponseEntity.status(HttpStatus.OK).body(clienteDto);
    }
    
    @GetMapping("/{cpf}")
    public ResponseEntity<Object> getCustomer(@PathVariable String cpf){

        //service.getClient(cpf);

        return ResponseEntity.status(HttpStatus.OK).body(new ClienteDto());
    }

}
