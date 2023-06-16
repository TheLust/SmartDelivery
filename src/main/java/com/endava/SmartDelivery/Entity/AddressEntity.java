package com.endava.SmartDelivery.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String unitNumber;


    @Column(nullable = false)
    private int streetNumber;

    @Column(nullable = false)
    private String addressLine1;

    private String addressLine2;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String region;

    private String postalCode;

    @ManyToOne
    @NotNull
    private CountryEntity country;
}
