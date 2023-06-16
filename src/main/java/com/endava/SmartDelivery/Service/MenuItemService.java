package com.endava.SmartDelivery.Service;


import com.endava.SmartDelivery.DAO.MenuItemDAO;
import com.endava.SmartDelivery.DAO.RestaurantDAO;
import com.endava.SmartDelivery.Entity.DTO.MenuItemDTO;
import com.endava.SmartDelivery.Entity.MenuItemEntity;
import com.endava.SmartDelivery.Entity.RestaurantEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MenuItemService {
    private final MenuItemDAO menuItemDAO;
    private final RestaurantDAO restaurantDAO;

    public List<Object> getAll() {
        return List.of(menuItemDAO.findAll());
    }

    public void add(MenuItemDTO menuItemDTO) {
        MenuItemEntity menuItem = new MenuItemEntity();
        menuItem.setName(menuItemDTO.getName());
        menuItem.setPrice(menuItemDTO.getPrice());

        RestaurantEntity restaurant = restaurantDAO.findByName(menuItemDTO.getRestaurantName());
        menuItem.setRestaurant(restaurant);

        menuItemDAO.save(menuItem);
    }

    public void update(long id, MenuItemDTO menuItemDTO) {
        MenuItemEntity menuItem = menuItemDAO.getById(id);
        menuItem.setName(menuItemDTO.getName());
        menuItem.setPrice(menuItemDTO.getPrice());

        RestaurantEntity restaurant = restaurantDAO.findByName(menuItemDTO.getRestaurantName());
        menuItem.setRestaurant(restaurant);

        menuItemDAO.save(menuItem);
    }

    public void delete(long id) {
        menuItemDAO.deleteById(id);
    }
}
