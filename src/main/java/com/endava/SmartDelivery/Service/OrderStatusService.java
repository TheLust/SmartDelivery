package com.endava.SmartDelivery.Service;

import com.endava.SmartDelivery.DAO.OrderStatusDAO;
import com.endava.SmartDelivery.Entity.DTO.OrderStatusDTO;
import com.endava.SmartDelivery.Entity.OrderStatusEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderStatusService {
    private final OrderStatusDAO orderStatusDAO;

    public List<Object> getAll() {
        return List.of(orderStatusDAO.findAll());
    }

    public void add(OrderStatusDTO orderStatusDTO) {
        OrderStatusEntity orderStatus = new OrderStatusEntity();
        orderStatus.setStatus(orderStatusDTO.getStatus());
        orderStatusDAO.save(orderStatus);
    }

    public void update(long id, OrderStatusDTO orderStatusDTO) {
        OrderStatusEntity orderStatus = orderStatusDAO.getById(id);
        orderStatus.setStatus(orderStatusDTO.getStatus());
        orderStatusDAO.save(orderStatus);
    }

    public void delete(long id) {
        orderStatusDAO.deleteById(id);
    }
}
