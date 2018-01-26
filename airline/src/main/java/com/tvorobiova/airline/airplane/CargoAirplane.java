package com.tvorobiova.airline.airplane;

import com.tvorobiova.airline.airplane.fueltank.FuelTank;

public class CargoAirplane extends HeavyPlane{
	
	public CargoAirplane(String aircraftId, int aircraftWeight, int flightRange, FuelTank fuelTank) {
		super(aircraftId, aircraftWeight, flightRange, fuelTank);
	}
		
	public double countMaxTotalCapacity() {
		return countMaxCarriageCapacity() + fuelTank.countMaxFuelCapacity() + aircraftWeight;
	}
	
	@Override
	public double countMaxCarriageCapacity() {
		return storage.getMaxWeightCapacity();
	}

	public double countCurrentTotalCapacity() {
		return countCurrentCarriageCapacity() + fuelTank.countCurrentFuelCapacity() + aircraftWeight;
	}

	@Override
	public double countCurrentCarriageCapacity() {
		return storage.countTotalCapacity();
	}
}
