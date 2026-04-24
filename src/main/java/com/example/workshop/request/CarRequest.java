package com.example.workshop.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarRequest {
    private String vin;
    private String registrationNumber;
    private long clientId;
}
