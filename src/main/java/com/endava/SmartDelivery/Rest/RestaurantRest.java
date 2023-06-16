package com.endava.SmartDelivery.Rest;

import com.endava.SmartDelivery.Entity.DTO.RestaurantDTO;
import com.endava.SmartDelivery.Service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantRest {
    private final RestaurantService restaurantService;

    @PostMapping("/add")
    public ResponseEntity<Object> addNewRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        try {
            restaurantService.add(restaurantDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllRestaurants() {
        try {
            return new ResponseEntity<>(restaurantService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteRestaurant(@PathVariable long id) {
        try {
            restaurantService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateRestaurant(@PathVariable long id, @RequestBody RestaurantDTO restaurantDTO) {
        try {
            restaurantService.update(id, restaurantDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
