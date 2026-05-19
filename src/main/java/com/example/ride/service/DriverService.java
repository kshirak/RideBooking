package com.example.ride.service;

import com.example.ride.entity.Driver;
import com.example.ride.enums.DriverStatus;
import com.example.ride.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    DriverRepository repo;

    public void registerDriver(Driver driver) {
        repo.save(driver);
    }

    public void updateStatus(int id,
                             DriverStatus status) {

        Driver driver =
                repo.findById(id).orElse(null);

        if(driver != null){
            driver.setStatus(status);
            repo.save(driver);
        }
    }

    public void viewDrivers() {
        repo.findAll().forEach(System.out::println);
    }
}