package com.tvorobiova.airline.airplane;

import com.tvorobiova.airline.airplane.fueltank.FuelTank;
import com.tvorobiova.airline.airplane.passenger.PassengerLaunge;

public class Helicopter extends Aircraft {

	public Helicopter(String aircraftId, int aircraftWeight, int flightRange, FuelTank fuelTank) {
		super(aircraftId, aircraftWeight, flightRange, fuelTank);
	}

	private PassengerLaunge launge;

	public double countMaxTotalCapacity() {
		return fuelTank.countMaxFuelCapacity() + aircraftWeight;
	}
	
	public double countCurrentTotalCapacity() {
		return fuelTank.countCurrentFuelCapacity() + aircraftWeight;
	}

	public PassengerLaunge getLaunge() {
		return launge;
	}

	public void setLaunge(PassengerLaunge launge) {
		this.launge = launge;
	}


}
