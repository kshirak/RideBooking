package com.example.ride;

import com.example.ride.entity.Driver;
import com.example.ride.entity.User;
import com.example.ride.enums.DriverStatus;
import com.example.ride.service.DriverService;
import com.example.ride.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class RideApplication
        implements CommandLineRunner {

    @Autowired
    UserService userService;

    @Autowired
    DriverService driverService;

    public static void main(String[] args) {
        SpringApplication.run(
                RideApplication.class,
                args
        );
    }

    @Override
    public void run(String... args) {
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("\n===== MENU =====");
            System.out.println("1. Register User");
            System.out.println("2. Register Driver");
            System.out.println("3. View Users");
            System.out.println("4. View Drivers");
            System.out.println("5. Exit");
            int choice = scan.nextInt();

            switch(choice){

                case 1:

                    System.out.print("User ID : ");
                    int uid = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Name : ");
                    String uname = scan.nextLine();
                    System.out.print("Phone : ");
                    String phone = scan.nextLine();
                    System.out.print("Email : ");
                    String email = scan.nextLine();
                    System.out.print("Latitude : ");
                    double lat = scan.nextDouble();
                    System.out.print("Longitude : ");
                    double lon = scan.nextDouble();
                    scan.nextLine();
                    System.out.print("City : ");
                    String city = scan.nextLine();
                    User user =
                            new User(uid,
                                    uname,
                                    phone,
                                    email,
                                    lat,
                                    lon,
                                    city);
                    userService.registerUser(user);
                    System.out.println("User Registered!");
                    break;

                case 2:

                    System.out.print("Driver ID : ");
                    int did = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Name : ");
                    String dname = scan.nextLine();
                    System.out.print("Phone : ");
                    String dphone = scan.nextLine();
                    System.out.print("Vehicle No : ");
                    String vehicle = scan.nextLine();
                    System.out.print("City : ");
                    String dcity = scan.nextLine();
                    Driver driver =
                            new Driver(did,
                                    dname,
                                    dphone,
                                    vehicle,
                                    dcity,
                                    DriverStatus.AVAILABLE);
                    driverService.registerDriver(driver);
                    System.out.println("Driver Registered!");
                    break;

                case 3:
                    userService.viewUsers();
                    break;

                case 4:
                    driverService.viewDrivers();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}