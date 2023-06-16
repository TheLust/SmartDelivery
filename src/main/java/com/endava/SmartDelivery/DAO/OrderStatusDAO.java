package com.endava.SmartDelivery.DAO;

import com.endava.SmartDelivery.Entity.OrderStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusDAO extends JpaRepository<OrderStatusEntity, Long> {
    OrderStatusEntity findByStatus(String status);
}
