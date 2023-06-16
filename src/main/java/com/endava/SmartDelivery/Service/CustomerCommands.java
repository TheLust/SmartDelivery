package com.endava.SmartDelivery.Service;

import com.endava.SmartDelivery.DAO.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class CustomerCommands {

    private final UserDAO userDAO;
    private final CustomerDAO customerDAO;
    private final OrderDAO orderDAO;
    private final OrderStatusDAO orderStatusDAO;

    public void orderSomething(String restaurantName,
                               String itemName,
                               int quantity) {

    }
}
