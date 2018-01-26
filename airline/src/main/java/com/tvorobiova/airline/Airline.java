package com.tvorobiova.airline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.tvorobiova.airline.airplane.Aircraft;
import com.tvorobiova.airline.airplane.HeavyPlane;

public class Airline {

	private List<Aircraft> airplanes = new ArrayList<>();

	public double calculateTotalCapacity() {
		return airplanes.stream().map(plane -> plane.countMaxTotalCapacity()).reduce(0.0, Double::sum);
	}

	public double calculateCarryingCapacity() {
		return airplanes.stream().filter(plane -> plane instanceof HeavyPlane)
				.map(plane -> ((HeavyPlane) plane).countMaxCarriageCapacity()).reduce(0.0, Double::sum);
	}

	public double calculateCurrentCapacity(){
		return airplanes.stream().map(plane -> plane.countCurrentTotalCapacity()).reduce(0.0, Double::sum);
	}
	
	public boolean addAircraft(Aircraft aircraft) {
		return airplanes.add(aircraft);
	}
	
	public boolean addAircraft(Set<Aircraft> aircrafts) {
		return airplanes.addAll(aircrafts);
	}

	public void printAllAircrafts() {
		Collections.sort(airplanes, (a1, a2) -> a1.compareTo(a2));
		airplanes.stream().map(plane -> "Aircraft ID: " + plane.getAircraftId() + "     Flight Range: " + plane.getFlightRange() + " kg    Fuel Consumption: " + plane.getFuelConsumtion() + " lit/hour ")
				.collect(Collectors.toList()).forEach(System.out::println);
	}

	public void find(int fuelConsumptionStart, int fuelConsumptionEnd) {

		airplanes.stream()
				.filter(plane -> plane.getFuelConsumtion() >= fuelConsumptionStart
						&& plane.getFuelConsumtion() <= fuelConsumptionEnd)
				.collect(Collectors.toSet()).stream()
				.map(filteredPlane -> "Aircraft ID: " + filteredPlane.getAircraftId())
				.collect(Collectors.toSet()).forEach(System.out::println);
	}

	public List<Aircraft> getAirplanes() {
		return airplanes;
	}

	public void setAirplanes(List<Aircraft> airplanes) {
		this.airplanes = airplanes;
	}

}
