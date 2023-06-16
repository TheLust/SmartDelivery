package com.endava.SmartDelivery.Service;

import com.endava.SmartDelivery.DAO.CountryDAO;
import com.endava.SmartDelivery.Entity.CountryEntity;
import com.endava.SmartDelivery.Entity.DTO.CountryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CountryService {
    private final CountryDAO countryDAO;

    public List<Object> getAll() {
        return List.of(countryDAO.findAll());
    }

    public void add(CountryDTO countryDTO) {
        CountryEntity country = new CountryEntity();
        country.setName(countryDTO.getName());
        country.setCode(countryDTO.getCode());
        countryDAO.save(country);
    }

    public void update(int id, CountryDTO countryDTO) {
        CountryEntity country = countryDAO.getById(id);
        country.setName(countryDTO.getName());
        country.setCode(countryDTO.getCode());
        countryDAO.save(country);
    }

    public void delete(int id) {
        countryDAO.deleteById(id);
    }
}
