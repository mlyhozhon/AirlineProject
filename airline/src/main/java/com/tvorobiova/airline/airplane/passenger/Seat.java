package com.tvorobiova.airline.airplane.passenger;

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
		if (!isEmpty()) {
			this.passenger = passenger;
			return true;
		}
		return false;
	}

	public boolean isEmpty() {
		return passenger == null;
	}

}
