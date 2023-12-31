package com.territory.cityprovince.services;


import com.territory.cityprovince.dto.CityDelRequest;
import com.territory.cityprovince.dto.CityRequest;
import com.territory.cityprovince.dto.CityResponse;
import com.territory.cityprovince.dto.CityUpdRequest;
import com.territory.cityprovince.entities.City;

import java.util.List;

public interface CityService {
    List<City> allCity();

    CityResponse addCity(CityRequest cityRequest);

    void delCity(CityDelRequest cityDelRequest);

    CityResponse updCity(CityUpdRequest cityUpdRequest);

}
