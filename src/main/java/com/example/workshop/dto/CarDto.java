package com.example.workshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDto {
    private String brand;
    private String model;
    private Integer productionYear;
    private String registrationNumber;
}
