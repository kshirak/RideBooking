package com.example.ride.service;
import org.springframework.stereotype.Service;

@Service
public class PricingService {
    public double calculateSurge(int demand,
                                 int supply){
        if(supply == 0) return 3.0;
        if(demand > supply) return 2.0;
        return 1.0;
    }
}