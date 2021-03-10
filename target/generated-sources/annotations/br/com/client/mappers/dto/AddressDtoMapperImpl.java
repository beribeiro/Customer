package br.com.client.mappers.dto;

import br.com.client.domain.Endereco;
import br.com.client.dto.EnderecoDto;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-10T12:02:58-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_281 (Oracle Corporation)"
)
public class AddressDtoMapperImpl extends AddressDtoMapper {

    @Override
    public Endereco mapFrom(EnderecoDto enderecoDto) {
        if ( enderecoDto == null ) {
            return null;
        }

        Endereco endereco = new Endereco();

        endereco.setAddress( enderecoDto.getAddress() );
        endereco.setDistrict( enderecoDto.getDistrict() );
        endereco.setCity( enderecoDto.getCity() );
        endereco.setState( enderecoDto.getState() );
        if ( enderecoDto.getZipCode() != null ) {
            endereco.setZipCode( Integer.parseInt( enderecoDto.getZipCode() ) );
        }

        return endereco;
    }
}
