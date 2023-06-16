package com.endava.SmartDelivery.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class OrderMenuItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @NotNull
    private OrderEntity order;

    @ManyToOne
    @NotNull
    private MenuItemEntity menuItem;

    @NotNull
    private int quantity;
}
