package com.example.ride.service;
import com.example.ride.entity.Trip;
import com.example.ride.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripService {
    @Autowired
    TripRepository repo;
    public void saveTrip(Trip trip){
        repo.save(trip);
    }
    public void viewTrips(){
        repo.findAll().forEach(System.out::println);
    }
}