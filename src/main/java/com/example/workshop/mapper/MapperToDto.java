package com.example.workshop.mapper;

import com.example.workshop.dto.CarDto;
import com.example.workshop.dto.ClientDto;
import com.example.workshop.dto.MechanicDto;
import com.example.workshop.dto.RepairDto;
import com.example.workshop.entity.Car;
import com.example.workshop.entity.Client;
import com.example.workshop.entity.Mechanic;
import com.example.workshop.entity.Repair;
import org.springframework.stereotype.Component;

@Component
public class MapperToDto {
    public CarDto mapCarToDto(Car car) {
        return CarDto.builder()
                .brand(car.getBrand())
                .model(car.getModel())
                .productionYear(car.getProductionYear())
                .registrationNumber(car.getRegistrationNumber())
                .build();
    }

    public ClientDto mapClientToDto(Client client) {
        return ClientDto.builder()
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .email(client.getEmail())
                .build();
    }

    public MechanicDto mapMechanicToDto(Mechanic mechanic) {
        return MechanicDto.builder()
                .firstName(mechanic.getFirstName())
                .lastName(mechanic.getLastName())
                .build();
    }

    public RepairDto mapRepairToDto(Repair repair) {
        return RepairDto.builder()
                .description(repair.getDescription())
                .status(repair.getStatus())
                .laborHours(repair.getLaborHours())
                .partsCost(repair.getPartsCost())
                .totalCost(repair.getTotalCost())
                .build();
    }


}
