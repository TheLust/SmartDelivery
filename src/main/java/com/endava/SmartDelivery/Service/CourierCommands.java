package com.endava.SmartDelivery.Service;

import com.endava.SmartDelivery.DAO.CourierDAO;
import com.endava.SmartDelivery.DAO.OrderDAO;
import com.endava.SmartDelivery.DAO.OrderStatusDAO;
import com.endava.SmartDelivery.DAO.UserDAO;
import com.endava.SmartDelivery.Entity.CourierEntity;
import com.endava.SmartDelivery.Entity.OrderEntity;
import com.endava.SmartDelivery.Entity.OrderStatusEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class CourierCommands {

    private final UserDAO userDAO;
    private final CourierDAO courierDAO;
    private final OrderDAO orderDAO;
    private final OrderStatusDAO orderStatusDAO;

    public long getCourierId() {
        return courierDAO.findIdByUser(userDAO.findByUsername(((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()));
    }

    public void assignOrder(long idOrder) {

        CourierEntity courier = courierDAO.findById(getCourierId()).get();
        OrderEntity order = orderDAO.getById(idOrder);
        order.setCourier(courier);
        OrderStatusEntity orderStatus = orderStatusDAO.findByStatus("active");
        order.setOrderStatus(orderStatus);
        orderDAO.save(order);
    }
}
