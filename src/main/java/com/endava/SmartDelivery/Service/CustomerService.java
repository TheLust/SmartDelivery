package com.endava.SmartDelivery.Service;

import com.endava.SmartDelivery.DAO.CustomerDAO;
import com.endava.SmartDelivery.DAO.UserDAO;
import com.endava.SmartDelivery.Entity.CustomerEntity;
import com.endava.SmartDelivery.Entity.DTO.CustomerDTO;
import com.endava.SmartDelivery.Entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerDAO customerDAO;
    private final UserDAO userDAO;

    public List<Object> getAll() {
        return List.of(customerDAO.findAll());
    }

    public void add(CustomerDTO customerDTO) {
        CustomerEntity customer = new CustomerEntity();
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());

        UserEntity user = userDAO.findById(customerDTO.getUserId()).get();
        customer.setUser(user);

        customerDAO.save(customer);
    }

    public void update(long id, CustomerDTO customerDTO) {
        CustomerEntity customer = customerDAO.getById(id);
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());

        UserEntity user = userDAO.findById(customerDTO.getUserId()).get();
        customer.setUser(user);

        customerDAO.save(customer);
    }

    public void delete(long id) {
        customerDAO.deleteById(id);
    }
}
