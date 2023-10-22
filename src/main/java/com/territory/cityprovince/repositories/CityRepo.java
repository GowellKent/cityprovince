package com.territory.cityprovince.repositories;

import com.territory.cityprovince.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepo extends JpaRepository<City, Long> {
    Optional<City> findByName(String name);
}
