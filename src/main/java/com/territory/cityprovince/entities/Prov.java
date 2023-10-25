package com.territory.cityprovince.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Prov {
    @Id
    @SequenceGenerator(name = "prov_sequence", sequenceName =  "prov_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prov_sequence")
    private Long id;

    @Column(length = 30, nullable = false)
    private String name;

    @OneToMany(mappedBy = "prov")
    private List<City> cities;

    public Prov(String name) {
        this.name = name;
    }
}
