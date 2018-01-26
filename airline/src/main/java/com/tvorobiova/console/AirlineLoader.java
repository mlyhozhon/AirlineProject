package com.tvorobiova.console;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.tvorobiova.airline.Airline;
import com.tvorobiova.airline.airplane.Aircraft;
import com.tvorobiova.airline.airplane.CargoAirplane;
import com.tvorobiova.airline.airplane.Helicopter;
import com.tvorobiova.airline.airplane.PassengerPlane;
import com.tvorobiova.airline.airplane.fueltank.FuelTank;
import com.tvorobiova.airline.airplane.passenger.PassengerLaunge;
import com.tvorobiova.airline.airplane.passenger.Seat;
import com.tvorobiova.airline.airplane.storage.Storage;

public class AirlineLoader {
	private static final Random numberCreator = new Random();
	private static final int MIN_WEIGHT = 100;
	private static final int MAX_CAPACITY = 100;
	private static final int MAX_WEIGHT = 100500;
	private static final int MAX_RANGE = 100500;
	private static final int MIN_RANGE = 100;
	private static final AirlineLoader instance = new AirlineLoader();
	
	 private AirlineLoader() {
		 
	}
	 public static AirlineLoader getInstance() {
		 return instance;
	 }
	// This method creates default Airline with random number of Helicopters, Passenger
	// planes and Cargo planes
	public Airline loadDefaultAirline() {
		Airline airline = new Airline();
		airline.addAircraft(createHelicoptes());
		airline.addAircraft(createCargoPlanes());
		airline.addAircraft(createPassengerPlanes());
		return airline;
	}

	private Set<Aircraft> createHelicoptes() {
		Set<Aircraft> helicopters = new HashSet<>();
		int helicoperCount = numberCreator.nextInt(10);
		for (int i = 0; i < helicoperCount; i++) {
			Helicopter helicopter = new Helicopter("HH" + i, numberCreator.nextInt(MAX_WEIGHT) + MIN_WEIGHT, numberCreator.nextInt(MAX_RANGE)+MIN_RANGE,
					createFuelTank());
			helicopter.setFuelConsumtion(numberCreator.nextInt(MAX_CAPACITY)+1);
			helicopters.add(helicopter);
		}
		return helicopters;
	}

	private Set<Aircraft> createCargoPlanes() {
		Set<Aircraft> planes = new HashSet<>();
		int planesCount = numberCreator.nextInt(10);
		for (int i = 0; i < planesCount; i++) {
			CargoAirplane plane = new CargoAirplane("CC" + i, numberCreator.nextInt(MAX_WEIGHT) + MIN_WEIGHT, numberCreator.nextInt(MAX_RANGE)+MIN_RANGE,
					createFuelTank());
			plane.setStorage(createStorage());
			plane.setFuelConsumtion(numberCreator.nextInt(MAX_CAPACITY)+1);
			planes.add(plane);
		}
		return planes;
	}

	private Set<Aircraft> createPassengerPlanes() {
		Set<Aircraft> planes = new HashSet<>();
		int planesCount = numberCreator.nextInt(10);
		for (int i = 0; i < planesCount; i++) {
			PassengerPlane plane = new PassengerPlane("PP" + i, numberCreator.nextInt(MAX_WEIGHT) + MIN_WEIGHT,numberCreator.nextInt(MAX_RANGE)+MIN_RANGE,
					createFuelTank());
			plane.setStorage(createStorage());
			plane.setLaunge(createPassengerLaunge());
			plane.setFuelConsumtion(numberCreator.nextInt(MAX_CAPACITY)+1);
			planes.add(plane);
		}
		return planes;
	}

	private FuelTank createFuelTank() {
		return new FuelTank(numberCreator.nextInt(MAX_CAPACITY) + MIN_WEIGHT);
	}

	private Storage createStorage() {
		return new Storage(numberCreator.nextInt(MAX_CAPACITY), numberCreator.nextInt());
	}

	private PassengerLaunge createPassengerLaunge() {
		return new PassengerLaunge(createSeats(numberCreator.nextInt(MAX_CAPACITY)));
	}

	private Set<Seat> createSeats(int seatsCount) {
		Set<Seat> seats = new HashSet<>();
		for (int i = 0; i < seatsCount; i++) {
			seats.add(new Seat("" + i));
		}
		return seats;
	}
}
