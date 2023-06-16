package com.endava.SmartDelivery.Rest;

import com.endava.SmartDelivery.Entity.DTO.MenuItemDTO;
import com.endava.SmartDelivery.Service.MenuItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/menuItem")
public class MenuItemRest {
    private final MenuItemService menuItemService;

    @PostMapping("/add")
    public ResponseEntity<Object> addNewRestaurant(@RequestBody MenuItemDTO menuItemDTO) {
        try {
            menuItemService.add(menuItemDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllRestaurants() {
        try {
            return new ResponseEntity<>(menuItemService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteRestaurant(@PathVariable long id) {
        try {
            menuItemService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateRestaurant(@PathVariable long id, @RequestBody MenuItemDTO menuItemDTO) {
        try {
            menuItemService.update(id, menuItemDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
