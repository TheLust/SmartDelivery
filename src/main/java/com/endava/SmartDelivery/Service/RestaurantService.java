package com.endava.SmartDelivery.Service;

import com.endava.SmartDelivery.DAO.AddressDAO;
import com.endava.SmartDelivery.DAO.RestaurantDAO;
import com.endava.SmartDelivery.Entity.AddressEntity;
import com.endava.SmartDelivery.Entity.DTO.RestaurantDTO;
import com.endava.SmartDelivery.Entity.RestaurantEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantDAO restaurantDAO;
    private final AddressDAO addressDAO;

    public List<Object> getAll() {
        return List.of(restaurantDAO.findAll());
    }

    public void add(RestaurantDTO restaurantDTO) {
        RestaurantEntity restaurant = new RestaurantEntity();
        restaurant.setName(restaurantDTO.getName());

        AddressEntity address = addressDAO.findById(restaurantDTO.getAddressId()).get();
        restaurant.setAddress(address);

        restaurantDAO.save(restaurant);
    }

    public void update(long id, RestaurantDTO restaurantDTO) {
        RestaurantEntity restaurant = restaurantDAO.getById(id);
        restaurant.setName(restaurantDTO.getName());

        AddressEntity address = addressDAO.findById(restaurantDTO.getAddressId()).get();
        restaurant.setAddress(address);

        restaurantDAO.save(restaurant);
    }

    public void delete(long id) {
        restaurantDAO.deleteById(id);
    }
}
