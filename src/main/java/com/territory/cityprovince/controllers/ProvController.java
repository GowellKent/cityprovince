package com.territory.cityprovince.controllers;

import com.territory.cityprovince.dto.ProvDelRequest;
import com.territory.cityprovince.dto.ProvRequest;
import com.territory.cityprovince.dto.ProvResponse;
import com.territory.cityprovince.dto.ProvUpdRequest;
import com.territory.cityprovince.entities.Prov;
import com.territory.cityprovince.services.ProvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/province")
public class ProvController {

    @Autowired
    private ProvService provService;

    @GetMapping
    public List<Prov> allProv() {return provService.allProv();}

    @PostMapping("/add")
    public ResponseEntity<ProvResponse> addProv(@RequestBody ProvRequest provRequest) throws Exception{
        ProvResponse provResponse = provService.addProv(provRequest);
        return ResponseEntity.created(new URI("/add/")).body(provResponse);
    }

    @DeleteMapping("/del")
    public void delProv(@RequestBody ProvDelRequest provDelRequest){
        provService.delProv(provDelRequest);
    }

    @PutMapping("/upd")
    public ResponseEntity<ProvResponse> updProv(@RequestBody ProvUpdRequest provUpdRequest) throws Exception{
        ProvResponse provResponse = provService.updProv(provUpdRequest);
        return ResponseEntity.created(new URI("/upd")).body(provResponse);
    }
}
