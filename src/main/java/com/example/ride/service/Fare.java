package com.example.ride.service;

import org.springframework.stereotype.Service;

@Service
public class Fare {
    public double calculateFare(double distance,double surge){
        double baseFare=50;
        double perKm=10;
        return (baseFare+(distance*perKm))*surge;
    }
}