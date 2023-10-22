package com.territory.cityprovince.services.impl;

import com.territory.cityprovince.dto.CityRequest;
import com.territory.cityprovince.dto.CityResponse;
import com.territory.cityprovince.entities.City;
import com.territory.cityprovince.entities.Prov;
import com.territory.cityprovince.repositories.CityRepo;
import com.territory.cityprovince.repositories.ProvRepo;
import com.territory.cityprovince.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CItyServiceImpl implements CityService {

    @Autowired
    private CityRepo cityRepo;

    @Autowired
    private ProvRepo provRepo;

    public List<City> allCity(){ return cityRepo.findAll();}

    public CityResponse addCity(CityRequest cityRequest){
        Long provId = cityRequest.getProvId();

        Prov prov = provRepo.findById(provId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Province ID "+ provId + " Not Found!"));

        City city = new City();

        city.setName(cityRequest.getName());
        city.setProv(prov);
        prov.getCities().add(city);

        City newCity = cityRepo.save(city);

        return CityResponse.builder()
                .id(newCity.getId())
                .name(newCity.getName())
                .provId(provId)
                .build();
    }
}
