package com.endava.SmartDelivery.Rest;

import com.endava.SmartDelivery.Entity.DTO.AddressDTO;
import com.endava.SmartDelivery.Service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/address")
public class AddressRest {
    private final AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity<Object> addNewAddress(@RequestBody AddressDTO AddressDTO) {
        try {
            addressService.add(AddressDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllCountries() {
        try {
            return new ResponseEntity<>(addressService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteAddress(@PathVariable int id) {
        try {
            addressService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateAddress(@PathVariable int id, @RequestBody AddressDTO AddressDTO) {
        try {
            addressService.update(id, AddressDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
