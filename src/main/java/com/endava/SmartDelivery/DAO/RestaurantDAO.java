package com.endava.SmartDelivery.DAO;

import com.endava.SmartDelivery.Entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantDAO extends JpaRepository<RestaurantEntity, Long> {
    RestaurantEntity findByName(String name);
}
