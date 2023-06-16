package com.endava.SmartDelivery.DAO;

import com.endava.SmartDelivery.Entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryDAO extends JpaRepository<CountryEntity, Integer> {
    CountryEntity findByCode(String code);
}
