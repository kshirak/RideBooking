package com.example.ride.entity;

import jakarta.persistence.*;

@Entity
public class Pricing {

    @Id
    private int pricingId;

    private String city;
    private double surgeMultiplier;
    private int demand;
    private int supply;

    public Pricing() {
    }

    public Pricing(int pricingId,
                   String city,
                   double surgeMultiplier,
                   int demand,
                   int supply) {

        this.pricingId = pricingId;
        this.city = city;
        this.surgeMultiplier = surgeMultiplier;
        this.demand = demand;
        this.supply = supply;
    }

    public double getSurgeMultiplier() {
        return surgeMultiplier;
    }
}