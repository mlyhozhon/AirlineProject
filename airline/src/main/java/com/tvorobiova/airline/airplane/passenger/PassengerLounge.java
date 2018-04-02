package com.tvorobiova.airline.airplane.passenger;

import java.util.Collections;
import java.util.Set;

public class PassengerLounge {

	private final Set<Seat> seats;

	public PassengerLounge(Set<Seat> seats) {
		this.seats = Collections.unmodifiableSet(seats);
	}

	public int countMaxCarriageCapacity() {
		return seats.size() * Passenger.AVERAGE_PASSENGER_WEIGHT;
	}

	public double countTotalCapacity(){
		return seats.stream().filter(Seat::isNotEmpty).count() * Passenger.AVERAGE_PASSENGER_WEIGHT;
	}

	public Set<Seat> getSeats() {
		return seats;
	}
}
