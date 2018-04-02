package com.tvorobiova.airline.airplane.passenger;

import static java.util.Objects.nonNull;

public class Seat {
	private String seatNumber;
	private Passenger passenger;

	public Seat(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public boolean putPassenger(Passenger passenger) {
		if (isNotEmpty()) {
			this.passenger = passenger;
			return true;
		}
		return false;
	}

	public boolean isNotEmpty() {
		return nonNull(passenger);
	}

}
