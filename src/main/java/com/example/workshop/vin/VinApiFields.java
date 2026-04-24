package com.example.workshop.vin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VinApiFields {
    private String vin;
    private String brand;
    private String model;
    private Integer year;

    private String mileage;
    private String price;
    private String currency;

    private String registrationCountry;
    private String fuelType;
    private String color;
    private String bodyType;
    private String version;

    private String vehicleHistory;
    private String stolenCheck;
    private String vinDecoder;
}
