package com.example.ride.entity;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    private int userId;

    private String name;
    private String phone;
    private String email;
    private double latitude;
    private double longitude;
    private String city;

    public User() {
    }

    public User(int userId, String name, String phone,
                String email,
                double latitude,
                double longitude,
                String city) {

        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
    }

    public int getUserId() {
        return userId;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {

        return "User ID : " + userId +
                "\nName : " + name +
                "\nPhone : " + phone +
                "\nCity : " + city;
    }
}