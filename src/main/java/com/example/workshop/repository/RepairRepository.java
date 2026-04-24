package com.example.workshop.repository;

import com.example.workshop.entity.Repair;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairRepository extends JpaRepository<Repair,Long> {
}
