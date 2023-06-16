package com.endava.SmartDelivery.DAO;

import com.endava.SmartDelivery.Entity.CourierEntity;
import com.endava.SmartDelivery.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierDAO extends JpaRepository<CourierEntity, Long> {
    long findIdByUser(UserEntity user);
}
