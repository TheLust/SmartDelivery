package com.endava.SmartDelivery.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String status;
}
