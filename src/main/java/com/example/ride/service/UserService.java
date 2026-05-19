package com.example.ride.service;

import com.example.ride.entity.User;
import com.example.ride.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public void registerUser(User user) {
        repo.save(user);
    }

    public void viewUsers() {
        repo.findAll().forEach(System.out::println);
    }

    public User getUser(int id) {
        return repo.findById(id).orElse(null);
    }
}