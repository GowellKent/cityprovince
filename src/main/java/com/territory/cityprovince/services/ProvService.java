package com.territory.cityprovince.services;

import com.territory.cityprovince.dto.ProvDelRequest;
import com.territory.cityprovince.dto.ProvRequest;
import com.territory.cityprovince.dto.ProvResponse;
import com.territory.cityprovince.dto.ProvUpdRequest;
import com.territory.cityprovince.entities.Prov;

import java.util.List;

public interface ProvService {
    List<Prov> allProv();

    ProvResponse addProv(ProvRequest provRequest);

    void delProv(ProvDelRequest provDelRequest);

    ProvResponse updProv(ProvUpdRequest provUpdRequest);

    Prov provById(ProvRequest provRequest);
}
