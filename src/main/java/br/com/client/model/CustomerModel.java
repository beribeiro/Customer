package br.com.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "CLIENT")
@NoArgsConstructor
@NamedQuery(name= CustomerModel.CONSULTA_CUSTOMER_CPF,
        query =" FROM Client client "
        + "WHERE client.cpf = :cpf")
public class CustomerModel {

    public static final String CONSULTA_CUSTOMER_CPF = "CONSULTA_CUSTOMER_CPF";

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
    private AddressModel addressModel;

    public CustomerModel(String name, String cpf, AddressModel addressModel) {
        this.name = name;
        this.cpf = cpf;
        this.addressModel = addressModel;
    }
}
