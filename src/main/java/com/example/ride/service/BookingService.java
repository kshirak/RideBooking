package com.example.ride.service;

import com.example.ride.entity.Booking;
import com.example.ride.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    BookingRepository repo;
    public void createBooking(Booking booking){
        repo.save(booking);
    }
    public void viewBookings(){
        repo.findAll().forEach(System.out::println);
    }
    public Booking getBooking(int id){
        return repo.findById(id).orElse(null);
    }
}