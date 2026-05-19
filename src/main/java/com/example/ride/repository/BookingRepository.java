package com.example.ride.repository;

import com.example.ride.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository
        extends JpaRepository<Booking, Integer> {
}