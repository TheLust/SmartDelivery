package com.endava.SmartDelivery.DAO;

import com.endava.SmartDelivery.Entity.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemDAO extends JpaRepository<MenuItemEntity, Long> {
}
