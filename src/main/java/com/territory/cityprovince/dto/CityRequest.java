package com.territory.cityprovince.dto;

import com.territory.cityprovince.entities.Prov;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityRequest {
    private String name;
    private Long provId;
}
