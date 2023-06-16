package com.endava.SmartDelivery.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @ManyToOne
    private CustomerEntity customer;

    @NotNull
    @ManyToOne
    private RestaurantEntity restaurant;

    @NotNull
    @ManyToOne
    private CustomerAddressEntity customerAddress;

    @NotNull
    @ManyToOne
    private OrderStatusEntity orderStatus;

    private LocalDateTime dateTime;

    private LocalDateTime requestedDeliveryDateTime;

    @ManyToOne
    private CourierEntity courier;

    private float fee;

    private float totalAmount;

    private int courierRating;

    private int restaurantRating;

}
