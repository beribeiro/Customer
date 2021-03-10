package br.com.client.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table
public class Address {

    @Id
    @GeneratedValue
    @Column(name ="ID_ADDRESS", nullable = false)
    private Long id;

    @Column(name = "ADDRESS",nullable = false)
    private String address;

    @Column(name = "DISTRICT",nullable = false)
    private String district;

    @Column(name = "CITY",nullable = false)
    private String city;

    @Column(name = "STATE",nullable = false)
    private String state;

    @Column(name = "ZIPCODE", nullable = false)
    private Integer zipCode;

}
