package com.territory.cityprovince.services.impl;

import com.territory.cityprovince.entities.City;
import com.territory.cityprovince.repositories.CityRepo;
import com.territory.cityprovince.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CItyServiceImpl implements CityService {

    @Autowired
    private CityRepo cityRepo;

    public List<City> allCity(){ return cityRepo.findAll();}
}
