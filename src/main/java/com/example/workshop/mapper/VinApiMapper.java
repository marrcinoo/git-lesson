package com.example.workshop.mapper;

import com.example.workshop.vin.VinApiFields;
import com.example.workshop.vin.VinResponse;
import org.springframework.stereotype.Component;

@Component
public class VinApiMapper {

    public VinResponse mapFieldsToResponse(VinApiFields fields) {
        return VinResponse.builder()
                .brand(fields.getBrand())
                .model(fields.getModel())
                .productionYear(fields.getYear())
                .build();
    }

}
