package com.endava.SmartDelivery.Rest;

import com.endava.SmartDelivery.Entity.DTO.CourierDTO;
import com.endava.SmartDelivery.Service.CourierService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/courier")
public class CourierRest {
    private final CourierService courierService;

    @PostMapping("/add")
    public ResponseEntity<Object> addNewRestaurant(@RequestBody CourierDTO courierDTO) {
        try {
            courierService.add(courierDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllRestaurants() {
        try {
            return new ResponseEntity<>(courierService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteRestaurant(@PathVariable long id) {
        try {
            courierService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateRestaurant(@PathVariable long id, @RequestBody CourierDTO courierDTO) {
        try {
            courierService.update(id, courierDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
