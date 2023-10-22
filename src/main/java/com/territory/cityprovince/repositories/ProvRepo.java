package com.territory.cityprovince.repositories;

import com.territory.cityprovince.entities.Prov;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProvRepo extends JpaRepository<Prov,Long> {

    Optional<Prov> findByName(String name);
}
