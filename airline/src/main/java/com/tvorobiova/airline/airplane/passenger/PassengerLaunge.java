package com.tvorobiova.airline.airplane.passenger;

import java.util.Collections;
import java.util.Set;

public class PassengerLaunge {

	private final Set<Seat> seats;

	public PassengerLaunge(Set<Seat> seats) {
		this.seats = Collections.unmodifiableSet(seats);
	}
	
	public int countMaxCarriageCapacity() {
		return seats.size() * Passenger.AVERAGE_PASSANGER_WEIGHT;
	}

	public double countTotalCapacity(){
		int countOfPassengers = 0; 
		for (Seat seat : seats) {
			if (!seat.isEmpty()){
				countOfPassengers++;
			}
		}
		return countOfPassengers * Passenger.AVERAGE_PASSANGER_WEIGHT;
	}
	
	public Set<Seat> getSeats() {
		return seats;
	}
}
