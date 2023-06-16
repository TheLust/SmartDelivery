package com.endava.SmartDelivery.DAO;

import com.endava.SmartDelivery.Entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AddressDAO extends JpaRepository<AddressEntity, Long> {
}
