package com.tvorobiova.airline.airplane;

import static java.util.Objects.requireNonNull;

import com.tvorobiova.airline.airplane.fueltank.FuelTank;
import com.tvorobiova.airline.airplane.passenger.PassengerLounge;
import com.tvorobiova.airline.airplane.storage.Storage;

public class PassengerPlane extends Plane {

	private PassengerLounge lounge;

	public PassengerPlane(String aircraftId, int aircraftWeight, int flightRange, FuelTank fuelTank,
			Storage storage, PassengerLounge lounge) {
		super(aircraftId, aircraftWeight, flightRange, fuelTank, storage);
		requireNonNull(lounge);
		this.lounge = lounge;
	}

	@Override
	public double countMaxCarriageCapacity() {
		return super.countMaxCarriageCapacity() + lounge.countMaxCarriageCapacity();
	}

	@Override
	public double countCurrentCarriageCapacity() {
		return super.countCurrentCarriageCapacity() + lounge.countTotalCapacity();
	}

	public PassengerLounge getLounge() {
		return lounge;
	}

}
