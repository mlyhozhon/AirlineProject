package com.tvorobiova.airline.airplane.fueltank;

public class FuelTank {

	private static final double FUEL_DENSITY = 0.8;
	private final int maxVolume;
	private int currentVolume;

	public FuelTank(int maxVolume) {
		this.maxVolume = maxVolume;
	}

	public double countCurrentFuelCapacity() {
		return currentVolume * FUEL_DENSITY;
	}

	public double countMaxFuelCapacity() {
		return maxVolume*FUEL_DENSITY;
	}

	public int getCurrentVolume() {
		return currentVolume;
	}

	public void setCurrentVolume(int currentVolume) {
		this.currentVolume = currentVolume;
	}

	public int getMaxVolume() {
		return maxVolume;
	}


}
