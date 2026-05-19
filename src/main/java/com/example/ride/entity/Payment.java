package com.example.ride.entity;

import com.example.ride.enums.PaymentStatus;
import jakarta.persistence.*;

@Entity
public class Payment {

    @Id
    private int paymentId;

    private double amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @OneToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    public Payment() {
    }

    public Payment(int paymentId,
                   double amount,
                   PaymentStatus status,
                   Trip trip) {

        this.paymentId = paymentId;
        this.amount = amount;
        this.status = status;
        this.trip = trip;
    }
}