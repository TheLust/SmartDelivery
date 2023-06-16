package com.endava.SmartDelivery.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;
}
