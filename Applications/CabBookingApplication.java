package CabBooking.Applications;

import java.util.ArrayList;
import java.util.List;

import CabBooking.Models.Driver;
import CabBooking.Models.Location;
import CabBooking.Models.Ride;
import CabBooking.Models.User;

public class CabBookingApplication {

	private List<User> users;
	private List<Driver> drivers;
	private List<Ride> rides;
	private Location destination;

	public CabBookingApplication() {
		this.users = new ArrayList<>();
		this.drivers = new ArrayList<>();
		this.rides = new ArrayList<>();
	}

	public synchronized void addUser(String name, String gender, int age) {
		users.add(new User(name, gender, age));
	}

	public synchronized void addDriver(String name, String gender, int age, String vehicleDetails,
			Location currentLocation) {
		drivers.add(new Driver(name, gender, age, vehicleDetails, currentLocation));
	}

	public synchronized String findRide(String userName, Location source, Location destination) {
		List<Driver> availableDrivers = new ArrayList<>();
		for (Driver driver : drivers) {
			if (driver.isAvailable() && isWithinRange(driver.getCurrentLocation(), source, 5)) {
				availableDrivers.add(driver);
			}
		}

		if (availableDrivers.isEmpty()) {
			return "No ride found";
		} else {
			StringBuilder sb = new StringBuilder();
			for (Driver driver : availableDrivers) {
				sb.append(driver.getName()).append(" [Available]\n");
			}
			return sb.toString().trim();
		}
	}

	private User getUserByName(String userName) {
		for (User user : users) {
			if (user.getName().equals(userName)) {
				return user;
			}
		}
		return null;
	}

	public synchronized void chooseRide(String userName, String driverName) {
		Driver selectedDriver = getDriverByName(driverName);
		User selectedUser = getUserByName(userName);
		if (selectedDriver != null && selectedUser != null) {
			selectedDriver.setAvailable(false);
			Location source = selectedDriver.getCurrentLocation();
			Location destination = this.destination; // Get destination from the CabBookingApplication
			rides.add(new Ride(selectedDriver, selectedUser, source, destination));
		}
	}



	private Driver getDriverByName(String driverName) {
		for (Driver driver : drivers) {
			if (driver.getName().equals(driverName)) {
				return driver;
			}
		}
		return null;
	}

	private boolean isWithinRange(Location location1, Location location2, int range) {
		int distance = Math.abs(location1.getX() - location2.getX()) + Math.abs(location1.getY() - location2.getY());
		return distance <= range;
	}


}
