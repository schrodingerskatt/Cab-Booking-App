package CabBooking;

import CabBooking.Applications.CabBookingApplication;
import CabBooking.Models.Location;

public class Main {

	public static void main(String[] args) {
		CabBookingApplication app = new CabBookingApplication();
		app.addUser("Abhishek", "M", 23);
		app.addUser("Rahul", "M", 29);
		app.addUser("Nandini", "F", 22);

		app.addDriver("Driver1", "M", 22, "Swift, KA-01-12345", new Location(10, 1));
		app.addDriver("Driver2", "M", 29, "Swift, KA-01-12345", new Location(11, 10));
		app.addDriver("Driver3", "M", 24, "Swift, KA-01-12345", new Location(5, 3));

		System.out.println(
				"Available rides for Abhishek: " + app.findRide("Abhishek", new Location(0, 0), new Location(20, 1)));
		System.out.println(
				"Available rides for Rahul: " + app.findRide("Rahul", new Location(10, 0), new Location(15, 3)));
		System.out.println(
				"Available rides for Nandini: " + app.findRide("Nandini", new Location(15, 6), new Location(20, 4)));

		app.chooseRide("Rahul", "Driver1");
		System.out.println("Available rides for Rahul after choosing: "
				+ app.findRide("Rahul", new Location(10, 0), new Location(15, 3)));
	}

}
