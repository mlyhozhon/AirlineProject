package com.tvorobiova.airline.airplane;

import static java.util.Objects.requireNonNull;

import com.tvorobiova.airline.airplane.fueltank.FuelTank;
import com.tvorobiova.airline.airplane.storage.Storage;

public class Plane extends Aircraft {

	private final Storage storage;

	public Plane(String aircraftId, int aircraftWeight, int flightRange, FuelTank fuelTank, Storage storage) {
		super(aircraftId, aircraftWeight, flightRange, fuelTank);
		requireNonNull(storage);
		this.storage = storage;
	}

	@Override
	public double countMaxCarriageCapacity() {
		return storage.getMaxWeightCapacity();
	}

	@Override
	public double countCurrentCarriageCapacity() {
		return storage.countTotalCapacity();
	}

	public Storage getStorage() {
		return storage;
	}
}
