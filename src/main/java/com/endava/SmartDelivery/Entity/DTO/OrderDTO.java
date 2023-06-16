package com.endava.SmartDelivery.Entity.DTO;

import com.endava.SmartDelivery.Entity.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private long customerId;
    private long restaurantId;
    private long customerAddressId;
    private long courierId;
    private String requestedDeliveryDateTime;
    private String dateTime;
    private long orderStatusId;
    private float fee;
    private float totalAmount;
    private int courierRating;
    private int restaurantRating;
}
