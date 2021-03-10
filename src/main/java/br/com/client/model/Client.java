package br.com.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "CLIENT")
@NoArgsConstructor
@NamedQuery(name= Client.CONSULTA_CLIENT_CPF,
        query =" FROM Client client "
        + "WHERE client.cpf = :cpf")
public class Client {

    public static final String CONSULTA_CLIENT_CPF = "CONSULTA_CLIENT_CPF";

    @Id
    @GeneratedValue
    @Column(name ="ID_CLIENT", updatable = false, nullable = false)
    private Long id;

    @Column(name = "NAME_CLIENT", nullable = false)
    private String name;

    @Column(name = "CPF_CLIENT", nullable = false)
    private String cpf;

    @OneToOne
    @JoinColumn(name = "ADDRESS_CLIENT", nullable = false)
    private Address address;

    public Client(String name, String cpf, Address address) {
        this.name = name;
        this.cpf = cpf;
        this.address = address;
    }
}
