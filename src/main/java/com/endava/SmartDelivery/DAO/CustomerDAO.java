package com.endava.SmartDelivery.DAO;

import com.endava.SmartDelivery.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<CustomerEntity, Long> {
}
