package com.territory.cityprovince.services.impl;

import com.territory.cityprovince.dto.ProvDelRequest;
import com.territory.cityprovince.dto.ProvRequest;
import com.territory.cityprovince.dto.ProvResponse;
import com.territory.cityprovince.dto.ProvUpdRequest;
import com.territory.cityprovince.entities.Prov;
import com.territory.cityprovince.repositories.ProvRepo;
import com.territory.cityprovince.services.ProvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProvServiceImpl implements ProvService {

    @Autowired
    private ProvRepo provRepo;

    @Override
    public List<Prov> allProv() {
        return provRepo.findAll();
    }

    public ProvResponse addProv(ProvRequest provRequest){
        Prov prov = new Prov();
        prov.setName(provRequest.getName().toUpperCase());

        Prov newProv = provRepo.save(prov);

        return ProvResponse.builder().id(newProv.getId()).name(newProv.getName()).build();
    }

    @Override
    public void delProv(ProvDelRequest provDelRequest) {
        boolean exists = provRepo.existsById(provDelRequest.getId());

        if(!exists){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Province ID " + provDelRequest.getId() + " Not Found!");
        }
        provRepo.deleteById(provDelRequest.getId());
        throw new ResponseStatusException(HttpStatus.OK);
    }

    public ProvResponse updProv(ProvUpdRequest provUpdRequest){
        Prov prov = provRepo.findById(provUpdRequest.getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Province ID " + provUpdRequest.getId() + " Not Found!"));

        String name = provUpdRequest.getName();

        if(name.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name Cannot be Empty!");
        }

        Optional<Prov> provOptional = provRepo.findByName(provUpdRequest.getName());
        if (provOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name Already Taken!");
        }

        prov.setName(provUpdRequest.getName().toUpperCase());
        provRepo.save(prov);

        return ProvResponse.builder().id(provUpdRequest.getId()).name(prov.getName()).build();
    }
}
