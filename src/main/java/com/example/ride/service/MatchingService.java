package com.example.ride.service;

import com.example.ride.entity.Driver;
import com.example.ride.enums.DriverStatus;
import com.example.ride.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatchingService {
    @Autowired
    DriverRepository repo;
    public Driver findDriver(){
        List<Driver> drivers =
                repo.findByStatus(
                        DriverStatus.AVAILABLE
                );
        if(drivers.isEmpty()) return null;
        Driver driver = drivers.get(0);
        driver.setStatus(DriverStatus.BUSY);
        repo.save(driver);
        return driver;
    }
}