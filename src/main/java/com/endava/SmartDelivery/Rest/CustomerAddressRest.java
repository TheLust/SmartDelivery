package com.endava.SmartDelivery.Rest;

import com.endava.SmartDelivery.Entity.DTO.CustomerAddressDTO;
import com.endava.SmartDelivery.Service.CustomerAddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/customerAddress")
public class CustomerAddressRest {
    private final CustomerAddressService customerAddressService;

    @PostMapping("/add")
    public ResponseEntity<Object> addNewCustomerAddress(@RequestBody CustomerAddressDTO customerAddressDTO) {
        try {
            customerAddressService.add(customerAddressDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllCustomerAddresses() {
        try {
            return new ResponseEntity<>(customerAddressService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCustomerAddress(@PathVariable long id) {
        try {
            customerAddressService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateRestaurant(@PathVariable long id, @RequestBody CustomerAddressDTO customerAddressDTO) {
        try {
            customerAddressService.update(id, customerAddressDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
