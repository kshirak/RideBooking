package com.example.ride.repository;

import com.example.ride.entity.Pricing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricingRepository
        extends JpaRepository<Pricing, Integer> {
}