package com.example.ride;

import java.util.*;
import com.example.ride.entity.Driver;
import com.example.ride.entity.User;
import com.example.ride.enums.DriverStatus;
import com.example.ride.service.DriverService;
import com.example.ride.service.UserService;
import com.example.ride.entity.Booking;
import com.example.ride.entity.Trip;
import com.example.ride.enums.RideStatus;
import com.example.ride.service.BookingService;
import com.example.ride.service.Fare;
import com.example.ride.service.MatchingService;
import com.example.ride.service.PricingService;
import com.example.ride.service.TripService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class RideApplication
        implements CommandLineRunner {

    @Autowired
    UserService userService;

    @Autowired
    DriverService driverService;

	@Autowired
	BookingService bookingService;

	@Autowired
	MatchingService matchingService;

	@Autowired
	Fare fareService;

	@Autowired
	PricingService pricingService;

	@Autowired
	TripService tripService;
    public static void main(String[] args) {
        SpringApplication.run(
                RideApplication.class,
                args
        );
    }

    @Override
    public void run(String... args) {
        
		Scanner scan=new Scanner(System.in);
        while(true){
            System.out.println("\n===== MENU =====");
            System.out.println("1. Register User");
            System.out.println("2. Register Driver");
            System.out.println("3. View Users");
            System.out.println("4. View Drivers");
			System.out.println("5. Book Ride");
			System.out.println("6. View Bookings");
			System.out.println("7. View Trips");
			System.out.println("8. Exit");
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
                    User bookinguser=new User(uid,uname,phone,email,lat,lon,city);
                    userService.registerUser(bookinguser);
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
                    String dcity=scan.nextLine();
                    Driver driver =new Driver(did,dname,dphone,vehicle,dcity,DriverStatus.AVAILABLE);
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
					System.out.print("Booking ID : ");
					int bid = scan.nextInt();
					System.out.print("User ID : ");
					int userId = scan.nextInt();
					scan.nextLine();
					User user=userService.getUser(userId);
					if(user == null){
						System.out.println("User Not Found!");
						break;
					}
					System.out.print("Pickup : ");
					String pickup=scan.nextLine();
					System.out.print("Drop : ");
					String drop=scan.nextLine();
					Booking booking=new Booking(bid,pickup,drop,RideStatus.REQUESTED,user);

					bookingService.createBooking(booking);
					Driver Assigneddriver=matchingService.findDriver();
					if(Assigneddriver == null){
						System.out.println("No Drivers Available!");
						break;
					}
					System.out.println("Driver Assigned : "+Assigneddriver);
					System.out.print("Distance KM : ");
					double distance = scan.nextDouble();
					double surge=pricingService.calculateSurge(10,5);
					double totalFare=fareService.calculateFare(distance,surge);
					Trip trip=new Trip(bid,distance,totalFare,RideStatus.ACCEPTED,booking,Assigneddriver);
					tripService.saveTrip(trip);
					System.out.println("Trip Created!");
					System.out.println("Total Fare : "+totalFare);
					break;

				case 6:
					bookingService.viewBookings();
					break;
				case 7:
					tripService.viewTrips();
					break;
                case 8:
                    System.exit(0);
            }
        }
    }
}