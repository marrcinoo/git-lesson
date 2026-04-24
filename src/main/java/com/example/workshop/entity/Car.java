package com.example.workshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String vin;

    private String brand;
    private String model;
    private Integer productionYear;
    private String registrationNumber;

    @ManyToOne
    private Client client;

    @OneToMany
    private List<Repair> repairs;

}
