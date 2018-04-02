package com.tvorobiova.airline.airplane.passenger;

public class Passenger {
	
	public static final int AVERAGE_PASSENGER_WEIGHT = 80;
	
	private String firstName;
	private String lastName;
	private String passport;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}
}
