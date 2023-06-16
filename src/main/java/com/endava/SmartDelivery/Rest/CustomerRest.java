package com.endava.SmartDelivery.Rest;

import com.endava.SmartDelivery.Entity.DTO.CustomerDTO;
import com.endava.SmartDelivery.Service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerRest {
    private final CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<Object> addNewRestaurant(@RequestBody CustomerDTO customerDTO) {
        try {
            customerService.add(customerDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllRestaurants() {
        try {
            return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteRestaurant(@PathVariable long id) {
        try {
            customerService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateRestaurant(@PathVariable long id, @RequestBody CustomerDTO customerDTO) {
        try {
            customerService.update(id, customerDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}