package com.example.workshop.dto;

import com.example.workshop.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RepairDto {
    private String description;
    private Status status;
    private int laborHours;
    private double partsCost;
    private double totalCost;
}
