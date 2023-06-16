package com.endava.SmartDelivery.Rest;

import com.endava.SmartDelivery.Entity.DTO.OrderMenuItemDTO;
import com.endava.SmartDelivery.Service.OrderMenuItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/orderMenuItem")
public class OrderMenuItemRest {
    private final OrderMenuItemService orderMenuItemService;

    @PostMapping("/add")
    public ResponseEntity<Object> addNewOrderStatus(@RequestBody OrderMenuItemDTO orderMenuItemDTO) {
        try {
            orderMenuItemService.add(orderMenuItemDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllOrderStatuses() {
        try {
            return new ResponseEntity<>(orderMenuItemService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCountry(@PathVariable long id) {
        try {
            orderMenuItemService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCountry(@PathVariable long id, @RequestBody OrderMenuItemDTO orderMenuItemDTO) {
        try {
            orderMenuItemService.update(id, orderMenuItemDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
