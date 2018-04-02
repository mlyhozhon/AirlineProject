package com.tvorobiova.airline;

import com.tvorobiova.airline.airplane.Aircraft;
import com.tvorobiova.airline.airplane.Plane;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Airline {

	private List<Aircraft> airplanes = new ArrayList<>();

	public double calculateTotalCapacity() {
		return airplanes.stream()
				.map(Aircraft::countMaxTotalCapacity)
				.reduce(0.0, Double::sum);
	}

	public double calculateCarryingCapacity() {
		return airplanes.stream()
				.filter(plane -> plane instanceof Plane)
				.map(plane -> ((Plane) plane).countMaxCarriageCapacity())
				.reduce(0.0, Double::sum);
	}

	public double calculateCurrentCapacity(){
		return airplanes.stream()
				.map(Aircraft::countCurrentTotalCapacity)
				.reduce(0.0, Double::sum);
	}
	
	public boolean addAircraft(Aircraft aircraft) {
		return airplanes.add(aircraft);
	}
	
	public boolean addAircraft(Set<Aircraft> aircrafts) {
		return airplanes.addAll(aircrafts);
	}

	public void printAllAircrafts() {
		airplanes.sort(Aircraft::compareTo);
		airplanes.stream()
				.map(Aircraft::toString)
				.forEach(System.out::println);
	}

	public void find(int fuelConsumptionStart, int fuelConsumptionEnd) {

		airplanes.stream()
				.filter(plane -> plane.getFuelConsumption() >= fuelConsumptionStart
						&& plane.getFuelConsumption() <= fuelConsumptionEnd)
				.map(filteredPlane -> "Aircraft ID: " + filteredPlane.getAircraftId())
				.forEach(System.out::println);
	}

	public List<Aircraft> getAirplanes() {
		return airplanes;
	}

	public void setAirplanes(List<Aircraft> airplanes) {
		this.airplanes = airplanes;
	}

}
