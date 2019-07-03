package com.apurvaaeron.springboot.angular.controllers;


import com.apurvaaeron.springboot.angular.dto.CountryDto;
import com.apurvaaeron.springboot.angular.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public List<CountryDto> getCountries() {
        return countryService.findAll();
    }


    @GetMapping("/countries/{pattern}")
    public List<CountryDto> getCountries(@PathVariable String pattern) {
        return countryService.findAll(pattern);
    }


    @GetMapping("/country/{id}")
    public CountryDto getCountry(@PathVariable String id) {
        return countryService.find(id);
    }

//    @PostMapping("/countries")
//    void addUser(@RequestBody User user) {
//        countryDataResolver.save(user);
//    }
}
