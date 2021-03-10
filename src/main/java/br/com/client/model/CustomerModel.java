package br.com.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.boot.model.source.spi.FetchCharacteristics;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "CUSTOMER")
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name= CustomerModel.CONSULTA_CUSTOMER_CPF,
                query =" FROM CustomerModel customer "
                        + "WHERE customer.cpf = :cpf")
})
public class CustomerModel {

    public static final String CONSULTA_CUSTOMER_CPF = "CONSULTA_CUSTOMER_CPF";

    @Id
    @GeneratedValue
    @Column(name ="ID_CUSTOMER", updatable = false, nullable = false)
    private Long id;

    @Column(name = "NAME_CUSTOMER", nullable = false)
    private String name;

    @Column(name = "CPF_CUSTOMER", nullable = false)
    private String cpf;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ID_ADDRESS", nullable = false)
    private AddressModel addressModel;

    public CustomerModel(String name, String cpf, AddressModel addressModel) {
        this.name = name;
        this.cpf = cpf;
        this.addressModel = addressModel;
    }
}
