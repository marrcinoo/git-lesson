package com.example.workshop.service;

import com.example.workshop.dto.CarDto;
import com.example.workshop.entity.Car;
import com.example.workshop.entity.Client;
import com.example.workshop.mapper.MapperToDto;
import com.example.workshop.mapper.VinApiMapper;
import com.example.workshop.repository.CarRepository;
import com.example.workshop.repository.ClientRepository;
import com.example.workshop.request.CarRequest;
import com.example.workshop.vin.VinApiFields;
import com.example.workshop.vin.VinClient;
import com.example.workshop.vin.VinResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final VinClient vinClient;
    private final VinApiMapper vinApiMapper;
    private final MapperToDto mapperToDto;
    private final CarRepository carRepository;
    private final ClientRepository clientRepository;

    public CarDto createNewCar(CarRequest request) {
        if (request.getVin() == null || request.getVin().length() != 17) {
            throw new IllegalArgumentException("Invalid VIN");
        }

        VinApiFields vinFields = vinClient.getVin(request.getVin());

        if (vinFields == null) {
            throw new RuntimeException("VIN not found");
        }
        VinResponse vinResponse = vinApiMapper.mapFieldsToResponse(vinFields);

        Client client = clientRepository.findById(request.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Car car = createCarEntity(request, vinResponse, client);

        Car saved = carRepository.save(car);
        return mapperToDto.mapCarToDto(saved);
    }

    private static Car createCarEntity(CarRequest request, VinResponse vinResponse, Client client) {
        return Car.builder()
                .vin(request.getVin())
                .registrationNumber(request.getRegistrationNumber())
                .brand(vinResponse.getBrand())
                .model(vinResponse.getModel())
                .productionYear(vinResponse.getProductionYear())
                .client(client)
                .build();
    }
    public CarDto getCar(long id) {
        return null;
    }

    public CarDto findCar(long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid person"));
        return mapperToDto.mapCarToDto(car);
    }

    //TODO: POST /cars
    //GET /cars/{id}
    //GET /cars
    //PUT /cars/{id}
    //DELETE /cars/{id}
    //Repair

}
