package com.territory.cityprovince.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProvUpdRequest {
    private Long id;
    private String name;
}
