package CabBooking.Models;

public class Ride {

	private Driver driver;
	private User user;
	private Location source;
	private Location destination;

	public Ride(Driver driver, User user, Location source, Location destination) {
		this.driver = driver;
		this.user = user;
		this.source = source;
		this.destination = destination;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Location getSource() {
		return source;
	}

	public void setSource(Location source) {
		this.source = source;
	}


}
