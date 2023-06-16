package com.endava.SmartDelivery.DAO;

import com.endava.SmartDelivery.Entity.OrderMenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMenuItemDAO extends JpaRepository<OrderMenuItemEntity, Long> {
}
