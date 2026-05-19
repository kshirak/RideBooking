package com.example.ride.entity;
import com.example.ride.enums.DriverStatus;
import jakarta.persistence.*;

@Entity
public class Driver {
    @Id
    private int driverId;
    private String name;
    private String phone;
    private String vehicleNo;
    private String city;
    @Enumerated(EnumType.STRING)
    private DriverStatus status;
    public Driver() {
    }
    public Driver(int driverId,String name,String phone,String vehicleNo,String city,DriverStatus status) {
        this.driverId = driverId;
        this.name = name;
        this.phone = phone;
        this.vehicleNo = vehicleNo;
        this.city = city;
        this.status = status;
    }

    public int getDriverId(){
        return driverId;
    }

    public DriverStatus getStatus(){
        return status;
    }

    public void setStatus(DriverStatus status){
        this.status = status;
    }

    @Override
    public String toString(){
        return "Driver ID : "+driverId+"\nName : "+name+"\nVehicle : "+vehicleNo+"\nStatus : "+status;
    }
}