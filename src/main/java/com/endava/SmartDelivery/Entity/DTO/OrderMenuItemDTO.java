package com.endava.SmartDelivery.Entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderMenuItemDTO {
    private long orderId;
    private long menuItemId;
    private int quantity;
}
