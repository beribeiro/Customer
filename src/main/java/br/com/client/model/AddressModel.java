package br.com.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ADDRESS")
@NoArgsConstructor
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID_ADDRESS", updatable = false)
    private Long id;

    @Column(name = "ADDRESS",nullable = false)
    private String address;

    @Column(name = "DISTRICT",nullable = false)
    private String district;

    @Column(name = "CITY",nullable = false)
    private String city;

    @Column(name = "STATE",nullable = false)
    private String state;

    @Column(name = "ZIP_CODE", nullable = false)
    private Integer zipCode;

    @OneToOne(mappedBy = "addressModel")
    private CustomerModel customerModel;

}
