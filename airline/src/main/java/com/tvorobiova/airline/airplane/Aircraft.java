package com.tvorobiova.airline.airplane;

import com.tvorobiova.airline.airplane.fueltank.FuelTank;
import java.util.Objects;

public abstract class Aircraft implements Comparable<Aircraft>{

	private final int aircraftWeight;
	private FuelTank fuelTank;
	private final String aircraftId;
	private double fuelConsumption;
	private Integer flightRange;

	Aircraft(String aircraftId, int aircraftWeight, int flightRange, FuelTank fuelTank) {
		this.aircraftWeight = aircraftWeight;
		this.fuelTank = fuelTank;
		this.aircraftId = aircraftId;
		this.flightRange = flightRange;
	}

	public abstract double countMaxCarriageCapacity();

	public abstract double countCurrentCarriageCapacity();

	public double countMaxTotalCapacity() {
		return fuelTank.countMaxFuelCapacity() + aircraftWeight + countMaxCarriageCapacity();
	}

	public double countCurrentTotalCapacity() {
		return fuelTank.countCurrentFuelCapacity() + aircraftWeight + countCurrentCarriageCapacity();
	}

	public double getFuelConsumption() {
		return fuelConsumption;
	}

	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
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
		return "Aircraft [Aircraft ID: " + aircraftId + ", fuelConsumption=" + fuelConsumption + ", flightRange="
				+ flightRange + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Aircraft aircraft = (Aircraft) o;
		return Objects.equals(aircraftId, aircraft.aircraftId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(aircraftId);
	}
}
