package com.endava.SmartDelivery.Service;

import com.endava.SmartDelivery.DAO.CourierDAO;
import com.endava.SmartDelivery.DAO.UserDAO;
import com.endava.SmartDelivery.Entity.CourierEntity;
import com.endava.SmartDelivery.Entity.DTO.CourierDTO;
import com.endava.SmartDelivery.Entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourierService {
    private final CourierDAO courierDAO;
    private final UserDAO userDAO;

    public List<Object> getAll() {
        return List.of(courierDAO.findAll());
    }

    public void add(CourierDTO courierDTO) {
        CourierEntity courier = new CourierEntity();
        courier.setFirstName(courierDTO.getFirstName());
        courier.setLastName(courierDTO.getLastName());

        UserEntity user = userDAO.findById(courierDTO.getUserId()).get();
        courier.setUser(user);

        courierDAO.save(courier);
    }

    public void update(long id, CourierDTO courierDTO) {
        CourierEntity courier = courierDAO.getById(id);
        courier.setFirstName(courierDTO.getFirstName());
        courier.setLastName(courierDTO.getLastName());

        UserEntity user = userDAO.findById(courierDTO.getUserId()).get();
        courier.setUser(user);

        courierDAO.save(courier);
    }

    public void delete(long id) {
        courierDAO.deleteById(id);
    }
}
