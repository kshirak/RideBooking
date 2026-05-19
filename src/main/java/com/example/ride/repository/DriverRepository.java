package com.example.ride.repository;

import com.example.ride.entity.Driver;
import com.example.ride.enums.DriverStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository
        extends JpaRepository<Driver, Integer> {

    List<Driver> findByStatus(DriverStatus status);
}