package com.endava.SmartDelivery.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class CustomerAddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    @NotNull
    private CustomerEntity customer;
    @OneToOne
    @NotNull
    private AddressEntity address;
}
