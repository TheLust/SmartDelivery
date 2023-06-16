package com.endava.SmartDelivery.Service;

import com.endava.SmartDelivery.DAO.*;
import com.endava.SmartDelivery.Entity.*;

import com.endava.SmartDelivery.Entity.DTO.AddressDTO;
import com.endava.SmartDelivery.Entity.DTO.OrderDTO;
import com.endava.SmartDelivery.Entity.DTO.OrderStatusDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderDAO orderDAO;
    private final CustomerDAO customerDAO;
    private final RestaurantDAO restaurantDAO;
    private final CustomerAddressDAO customerAddressDAO;
    private final OrderStatusDAO orderStatusDAO;
    private final CourierDAO courierDAO;

    public List<OrderEntity> getAll() {
        return orderDAO.findAll();
    }

    public void add(OrderDTO orderDTO) {
        OrderEntity order = new OrderEntity();

        CustomerEntity customer = customerDAO.findById(orderDTO.getCustomerId()).get();
        order.setCustomer(customer);

        RestaurantEntity restaurant = restaurantDAO.findById(orderDTO.getRestaurantId()).get();
        order.setRestaurant(restaurant);

        CustomerAddressEntity customerAddress = customerAddressDAO.findById(orderDTO.getCustomerAddressId()).get();
        order.setCustomerAddress(customerAddress);

        CourierEntity courier = courierDAO.findById(orderDTO.getCourierId()).get();
        order.setCourier(courier);

        OrderStatusEntity orderStatus = orderStatusDAO.findById(orderDTO.getOrderStatusId()).get();
        order.setOrderStatus(orderStatus);

        order.setDateTime(LocalDateTime.parse(orderDTO.getDateTime()));
        order.setFee(orderDTO.getFee());
        order.setTotalAmount(orderDTO.getTotalAmount());
        order.setRequestedDeliveryDateTime(LocalDateTime.parse(orderDTO.getRequestedDeliveryDateTime()));
        order.setCourierRating(orderDTO.getCourierRating());
        order.setRestaurantRating(orderDTO.getRestaurantRating());

        orderDAO.save(order);
    }

    public void delete(long id) {
        orderDAO.deleteById(id);
    }
}
