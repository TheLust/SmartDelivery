package com.endava.SmartDelivery.DAO;

import com.endava.SmartDelivery.Entity.CustomerAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAddressDAO extends JpaRepository<CustomerAddressEntity, Long> {
}
