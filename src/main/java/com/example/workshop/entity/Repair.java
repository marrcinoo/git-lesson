package com.example.workshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;
    private Status status;
    private int laborHours;
    private double partsCost;
    private double totalCost;
    private LocalDateTime createdAt;
    private LocalDateTime finishedAt;

    @ManyToOne
    private Car car;

    @ManyToOne
    private Mechanic mechanic;
}
