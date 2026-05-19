package com.example.ride.entity;

import com.example.ride.enums.RideStatus;
import jakarta.persistence.*;

@Entity
public class Trip {

    @Id
    private int tripId;

    private double distance;
    private double fare;

    @Enumerated(EnumType.STRING)
    private RideStatus tripStatus;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    public Trip() {
    }

    public Trip(int tripId,
                double distance,
                double fare,
                RideStatus tripStatus,
                Booking booking,
                Driver driver) {

        this.tripId = tripId;
        this.distance = distance;
        this.fare = fare;
        this.tripStatus = tripStatus;
        this.booking = booking;
        this.driver = driver;
    }

    public double getFare() {
        return fare;
    }

    @Override
    public String toString() {

        return "Trip ID : " + tripId +
                "\nDistance : " + distance +
                "\nFare : " + fare +
                "\nStatus : " + tripStatus;
    }
}