package com.example.workshop.service;

import com.example.workshop.dto.ClientDto;
import com.example.workshop.entity.Client;
import com.example.workshop.mapper.MapperToDto;
import com.example.workshop.repository.ClientRepository;
import com.example.workshop.request.ClientRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final MapperToDto mapper;

    public ClientDto create(ClientRequest clientRequest) {
        Client client = Client.builder()
                .firstName(clientRequest.getFirstName())
                .lastName(clientRequest.getLastName())
                .email(clientRequest.getEmail())
                .phoneNumber(clientRequest.getPhoneNumber())
                .build();
        Client save = clientRepository.save(client);
        return mapper.mapClientToDto(save);
    }

    public ClientDto getClient(long id) {
        return null;
    }

    //TODO: GET /clients/{id}
    //GET /clients
    //PUT /clients/{id}
    //DELETE /clients/{id}
    //Mechanic
}
