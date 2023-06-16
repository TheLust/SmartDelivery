package com.endava.SmartDelivery.Service;

import com.endava.SmartDelivery.DAO.AddressDAO;
import com.endava.SmartDelivery.DAO.CustomerAddressDAO;
import com.endava.SmartDelivery.DAO.CustomerDAO;
import com.endava.SmartDelivery.Entity.*;
import com.endava.SmartDelivery.Entity.DTO.CustomerAddressDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerAddressService {
    private final CustomerDAO customerDAO;
    private final AddressDAO addressDAO;
    private final CustomerAddressDAO customerAddressDAO;

    public List<Object> getAll() {
        return List.of(customerAddressDAO.findAll());
    }

    public void add(CustomerAddressDTO customerAddressDTO) {
        CustomerAddressEntity customerAddress = new CustomerAddressEntity();
        CustomerEntity customer = customerDAO.findById(customerAddressDTO.getCustomerId()).get();
        AddressEntity address = addressDAO.findById(customerAddressDTO.getAddressId()).get();
        customerAddress.setCustomer(customer);
        customerAddress.setAddress(address);

        customerAddressDAO.save(customerAddress);
    }

    public void update(long id, CustomerAddressDTO customerAddressDTO) {
        CustomerAddressEntity customerAddress = customerAddressDAO.getById(id);
        CustomerEntity customer = customerDAO.findById(customerAddressDTO.getCustomerId()).get();
        AddressEntity address = addressDAO.findById(customerAddressDTO.getAddressId()).get();
        customerAddress.setCustomer(customer);
        customerAddress.setAddress(address);

        customerAddressDAO.save(customerAddress);
    }

    public void delete(long id) {
        customerAddressDAO.deleteById(id);
    }
}
