package com.territory.cityprovince.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class City {
    @Id
    @SequenceGenerator(name = "city_sequence", sequenceName =  "city_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_sequence")
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "prov_id")
    private Prov prov;

    public City(String name, Prov prov) {
        this.name = name;
        this.prov = prov;
    }

    public void assignToProv(Prov prov){
        prov.getCities().add(this);
        this.prov = prov;
    }
}
