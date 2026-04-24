package com.example.workshop.vin;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VinResponse {
    private String brand;
    private String model;
    private int productionYear;
}
