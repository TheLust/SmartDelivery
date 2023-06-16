package com.endava.SmartDelivery.Rest;

import com.endava.SmartDelivery.Entity.DTO.CountryDTO;
import com.endava.SmartDelivery.Service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/country")
public class CountryRest {
    private final CountryService countryService;

    @PostMapping("/add")
    public ResponseEntity<Object> addNewCountry(@RequestBody CountryDTO countryDTO) {
        try {
            countryService.add(countryDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllCountries() {
        try {
            return new ResponseEntity<>(countryService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCountry(@PathVariable int id) {
        try {
            countryService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCountry(@PathVariable int id, @RequestBody CountryDTO countryDTO) {
        try {
            countryService.update(id, countryDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
