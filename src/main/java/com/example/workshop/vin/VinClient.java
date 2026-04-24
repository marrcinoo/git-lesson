package com.example.workshop.vin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class VinClient {
    private final WebClient vinWebClient;

    public VinApiFields getVin(String vin) {
        return vinWebClient.get()
                .uri("/vin/{vin}", vin)
                .retrieve()
                .bodyToMono(VinApiFields.class)
                .block();
    }
}
