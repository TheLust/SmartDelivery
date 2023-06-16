package com.endava.SmartDelivery.DAO;

import com.endava.SmartDelivery.Entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<OrderEntity, Long> {
}
