package com.endava.SmartDelivery.Service;

import com.endava.SmartDelivery.DAO.MenuItemDAO;
import com.endava.SmartDelivery.DAO.OrderDAO;
import com.endava.SmartDelivery.DAO.OrderMenuItemDAO;
import com.endava.SmartDelivery.Entity.DTO.OrderMenuItemDTO;
import com.endava.SmartDelivery.Entity.MenuItemEntity;
import com.endava.SmartDelivery.Entity.OrderEntity;
import com.endava.SmartDelivery.Entity.OrderMenuItemEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderMenuItemService {
    private final OrderMenuItemDAO orderMenuItemDAO;
    private final MenuItemDAO menuItemDAO;
    private final OrderDAO orderDAO;

    public List<Object> getAll() {
        return List.of(orderMenuItemDAO.findAll());
    }

    public void add(OrderMenuItemDTO orderMenuItemDTO) {
        OrderMenuItemEntity orderMenuItem = new OrderMenuItemEntity();

        MenuItemEntity menuItem = menuItemDAO.findById(orderMenuItemDTO.getMenuItemId()).get();
        orderMenuItem.setMenuItem(menuItem);
        OrderEntity order = orderDAO.findById(orderMenuItemDTO.getOrderId()).get();
        orderMenuItem.setOrder(order);
        orderMenuItem.setQuantity(orderMenuItemDTO.getQuantity());

        orderMenuItemDAO.save(orderMenuItem);
    }

    public void update(long id, OrderMenuItemDTO orderMenuItemDTO) {
        OrderMenuItemEntity orderMenuItem = orderMenuItemDAO.getById(id);

        MenuItemEntity menuItem = menuItemDAO.findById(orderMenuItemDTO.getMenuItemId()).get();
        orderMenuItem.setMenuItem(menuItem);
        OrderEntity order = orderDAO.findById(orderMenuItemDTO.getOrderId()).get();
        orderMenuItem.setOrder(order);
        orderMenuItem.setQuantity(orderMenuItemDTO.getQuantity());

        orderMenuItemDAO.save(orderMenuItem);
    }

    public void delete(long id) {
        orderMenuItemDAO.deleteById(id);
    }
}
