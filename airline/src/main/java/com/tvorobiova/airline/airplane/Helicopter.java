package com.tvorobiova.airline.airplane;

import static java.util.Objects.requireNonNull;

import com.tvorobiova.airline.airplane.fueltank.FuelTank;
import com.tvorobiova.airline.airplane.passenger.PassengerLounge;

public class Helicopter extends Aircraft {

	private PassengerLounge lounge;

	public Helicopter(String aircraftId, int aircraftWeight, int flightRange, FuelTank fuelTank, PassengerLounge lounge) {
		super(aircraftId, aircraftWeight, flightRange, fuelTank);
		requireNonNull(lounge);
		this.lounge = lounge;
	}

	@Override
	public double countMaxCarriageCapacity() {
		return lounge.countMaxCarriageCapacity();
	}

	@Override
	public double countCurrentCarriageCapacity() {
		return lounge.countTotalCapacity();
	}

	public PassengerLounge getLounge() {
		return lounge;
	}

	public void setLounge(PassengerLounge lounge) {
		this.lounge = lounge;
	}


}
