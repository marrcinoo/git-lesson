package com.example.workshop.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
