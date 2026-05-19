package com.example.ride.repository;

import com.example.ride.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository
        extends JpaRepository<Trip, Integer> {
}