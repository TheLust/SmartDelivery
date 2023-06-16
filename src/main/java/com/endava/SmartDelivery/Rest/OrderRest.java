package com.endava.SmartDelivery.Rest;

import com.endava.SmartDelivery.Entity.DTO.OrderDTO;
import com.endava.SmartDelivery.Entity.DTO.OrderStatusDTO;
import com.endava.SmartDelivery.Service.OrderService;
import com.endava.SmartDelivery.Service.OrderStatusService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderRest {
    private final OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<Object> addNewOrderStatus(@RequestBody OrderDTO orderDTO) {
        try {
            orderService.add(orderDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllOrderStatuses() {
        try {
            return new ResponseEntity<>(orderService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCountry(@PathVariable long id) {
        try {
            orderService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
