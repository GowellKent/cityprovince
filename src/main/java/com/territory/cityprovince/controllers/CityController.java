package com.territory.cityprovince.controllers;

import com.territory.cityprovince.dto.CityRequest;
import com.territory.cityprovince.dto.CityResponse;
import com.territory.cityprovince.entities.City;
import com.territory.cityprovince.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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

    @PostMapping("/add")
    public ResponseEntity<CityResponse> addCity(@RequestBody CityRequest cityRequest) throws Exception {
        CityResponse cityResponse = cityService.addCity(cityRequest);
        return ResponseEntity.created(new URI("/add/")).body(cityResponse);
    }
}
