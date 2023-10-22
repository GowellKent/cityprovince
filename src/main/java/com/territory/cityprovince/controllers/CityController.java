package com.territory.cityprovince.controllers;

import com.territory.cityprovince.entities.City;
import com.territory.cityprovince.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> allCity(){
        return cityService.allCity();
    }
}
