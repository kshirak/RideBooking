package com.example.ride.entity;

import com.example.ride.enums.RideStatus;
import jakarta.persistence.*;

@Entity
public class Booking {

    @Id
    private int bookingId;

    private String pickup;
    private String dropLocation;

    @Enumerated(EnumType.STRING)
    private RideStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Booking() {
    }

    public Booking(int bookingId,
                   String pickup,
                   String dropLocation,
                   RideStatus status,
                   User user) {

        this.bookingId = bookingId;
        this.pickup = pickup;
        this.dropLocation = dropLocation;
        this.status = status;
        this.user = user;
    }

    public int getBookingId() {
        return bookingId;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return "Booking ID : " + bookingId +
                "\nPickup : " + pickup +
                "\nDrop : " + dropLocation +
                "\nStatus : " + status;
    }
}