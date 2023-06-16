package com.endava.SmartDelivery.Rest;

import com.endava.SmartDelivery.Entity.DTO.OrderStatusDTO;
import com.endava.SmartDelivery.Service.OrderStatusService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/orderStatus")
public class OrderStatusRest {
    private final OrderStatusService orderStatusService;

    @PostMapping("/add")
    public ResponseEntity<Object> addNewOrderStatus(@RequestBody OrderStatusDTO orderStatusDTO) {
        try {
            orderStatusService.add(orderStatusDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllOrderStatuses() {
        try {
            return new ResponseEntity<>(orderStatusService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCountry(@PathVariable long id) {
        try {
            orderStatusService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCountry(@PathVariable long id, @RequestBody OrderStatusDTO orderStatusDTO) {
        try {
            orderStatusService.update(id, orderStatusDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}