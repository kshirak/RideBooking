package com.example.ride.repository;

import com.example.ride.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository
        extends JpaRepository<Payment, Integer> {
}