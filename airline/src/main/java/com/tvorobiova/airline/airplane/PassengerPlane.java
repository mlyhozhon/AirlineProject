package com.tvorobiova.airline.airplane;

import com.tvorobiova.airline.airplane.fueltank.FuelTank;
import com.tvorobiova.airline.airplane.passenger.PassengerLaunge;

public class PassengerPlane extends HeavyPlane {

	private PassengerLaunge launge;

	public PassengerPlane(String aircraftId, int aircraftWeight, int flightRange, FuelTank fuelTank) {
		super(aircraftId, aircraftWeight, flightRange, fuelTank);
	}

	public double countMaxTotalCapacity() {
		return countMaxCarriageCapacity() + fuelTank.countMaxFuelCapacity() + aircraftWeight;
	}

	public double countMaxCarriageCapacity() {
		return storage.getMaxWeightCapacity() + launge.countMaxCarriageCapacity();
	}

	public double countCurrentTotalCapacity() {
		return countCurrentCarriageCapacity() + fuelTank.countCurrentFuelCapacity() + aircraftWeight;
	}

	public double countCurrentCarriageCapacity() {
		return storage.countTotalCapacity() + launge.countTotalCapacity();
	}

	public PassengerLaunge getLaunge() {
		return launge;
	}

	public void setLaunge(PassengerLaunge launge) {
		if (this.launge == null) {
			this.launge = launge;
		} else {
			System.out.println("Passenger launge has been already added");
		}
	}

}
