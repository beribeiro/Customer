package br.com.client.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;


@Getter
@Setter
@Table(name = "CLIENT")
@NamedQuery(name= Client.CONSULTA_CLIENT_CPF,
        query =" FROM Client client "
        + "WHERE client.cpf = :cpf")
public class Client {

    public static final String CONSULTA_CLIENT_CPF = "CONSULTA_CLIENT_CPF";

    @Id
    @GeneratedValue
    @Column(name ="ID_CLIENT", nullable = false)
    private Long id;

    @Column(name = "NAME_CLIENT", nullable = false)
    private String name;

    @Column(name = "CPF_CLIENT", nullable = false)
    private Integer cpf;

    @OneToOne
    @JoinColumn(name = "ADDRESS_CLIENT", nullable = false)
    private Address address;
}
