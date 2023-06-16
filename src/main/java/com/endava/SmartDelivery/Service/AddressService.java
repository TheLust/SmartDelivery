package com.endava.SmartDelivery.Service;

import com.endava.SmartDelivery.DAO.AddressDAO;
import com.endava.SmartDelivery.DAO.CountryDAO;
import com.endava.SmartDelivery.Entity.CountryEntity;

import com.endava.SmartDelivery.Entity.AddressEntity;
import com.endava.SmartDelivery.Entity.DTO.AddressDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class AddressService {

    private final AddressDAO addressDAO;
    private final CountryDAO countryDAO;

    public List<AddressEntity> getAll() {
        return addressDAO.findAll();
    }

    public void add(AddressDTO addressDTO) {
        AddressEntity address = new AddressEntity();
        address.setUnitNumber(addressDTO.getUnitNumber());
        address.setStreetNumber(addressDTO.getStreetNumber());
        address.setAddressLine1(addressDTO.getAddressLine1());
        address.setAddressLine2(addressDTO.getAddressLine2());
        address.setCity(addressDTO.getCity());
        address.setRegion(addressDTO.getRegion());
        address.setPostalCode(addressDTO.getPostalCode());

        CountryEntity country = countryDAO.findByCode(addressDTO.getCountryCode());
        address.setCountry(country);

        addressDAO.save(address);
    }

    public void update(long id, AddressDTO addressDTO) {
        AddressEntity address = addressDAO.findById(id).orElseThrow(() -> new EntityNotFoundException("Address not found"));
        address.setUnitNumber(addressDTO.getUnitNumber());
        address.setStreetNumber(addressDTO.getStreetNumber());
        address.setAddressLine1(addressDTO.getAddressLine1());
        address.setAddressLine2(addressDTO.getAddressLine2());
        address.setCity(addressDTO.getCity());
        address.setRegion(addressDTO.getRegion());
        address.setPostalCode(addressDTO.getPostalCode());

        //CountryEntity country = countryDAO.findByCode(addressDTO.getCountryCode());
        //address.setCountry(country);

        addressDAO.save(address);
    }

    public void delete(long id) {
        addressDAO.deleteById(id);
    }
}
