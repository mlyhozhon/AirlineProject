package com.tvorobiova.airline.airplane;

import com.tvorobiova.airline.airplane.fueltank.FuelTank;
import com.tvorobiova.airline.airplane.storage.Storage;

public abstract class HeavyPlane extends Aircraft {

	protected Storage storage;

	protected HeavyPlane(String aircraftId, int aircraftWeight, int flightRange, FuelTank fuelTank) {
		super(aircraftId, aircraftWeight, flightRange, fuelTank);
	}

	public abstract double countCurrentCarriageCapacity();

	public abstract double countMaxCarriageCapacity();

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		if (this.storage == null) {
			this.storage = storage;
		}else{
			System.out.println("Storage has been already added");
		}
	}
}
