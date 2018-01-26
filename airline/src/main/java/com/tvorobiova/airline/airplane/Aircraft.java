package com.tvorobiova.airline.airplane;

import com.tvorobiova.airline.airplane.fueltank.FuelTank;

public abstract class Aircraft implements Comparable<Aircraft>{

	protected final int aircraftWeight;
	protected final FuelTank fuelTank;
	protected final String aircraftId;
	
	protected double fuelConsumtion;
	protected Integer flightRange;
	
	protected Aircraft(String aircraftId, int aircraftWeight, int flightRange, FuelTank fuelTank) {
		this.aircraftWeight = aircraftWeight;
		this.fuelTank = fuelTank;
		this.aircraftId = aircraftId;
		this.flightRange = flightRange;
	}

	public abstract double countMaxTotalCapacity();
	public abstract double countCurrentTotalCapacity();
	


	public double getFuelConsumtion() {
		return fuelConsumtion;
	}

	public void setFuelConsumtion(double fuelConsumtion) {
		this.fuelConsumtion = fuelConsumtion;
	}
	
	public int getFlightRange() {
		return flightRange;
	}

	public void setFlightRange(int flightRange) {
		this.flightRange = flightRange;
	}

	public String getAircraftId() {
		return aircraftId;
	}

	@Override
	public int compareTo(Aircraft compareAircraft) {
		return this.flightRange.compareTo(compareAircraft.getFlightRange());
	}

	@Override
	public String toString() {
		return "Aircraft [Aircraft ID: " + aircraftId + ", fuelConsumtion=" + fuelConsumtion + ", flightRange="
				+ flightRange + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aircraftId == null) ? 0 : aircraftId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aircraft other = (Aircraft) obj;
		if (aircraftId == null) {
			if (other.aircraftId != null)
				return false;
		} else if (!aircraftId.equals(other.aircraftId))
			return false;
		return true;
	}

	
}
