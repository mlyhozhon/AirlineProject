package com.tvorobiova.console;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.IntStream.range;

import com.tvorobiova.airline.Airline;
import com.tvorobiova.airline.airplane.Aircraft;
import com.tvorobiova.airline.airplane.Helicopter;
import com.tvorobiova.airline.airplane.PassengerPlane;
import com.tvorobiova.airline.airplane.Plane;
import com.tvorobiova.airline.airplane.fueltank.FuelTank;
import com.tvorobiova.airline.airplane.passenger.PassengerLounge;
import com.tvorobiova.airline.airplane.passenger.Seat;
import com.tvorobiova.airline.airplane.storage.Storage;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AirlineLoader {
	private static final Random numberCreator = new Random();
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
		for (AircraftCreator creator: asList(new HelicopterCreator(), new PlaneCreator(), new PassengerPlaneCreator())) {
			airline.addAircraft(createAircrafts(creator));
		}
		return airline;
	}

	private Set<Aircraft> createAircrafts(AircraftCreator creator) {
		return range(0, numberCreator.nextInt(10))
				.mapToObj(creator::create)
				.collect(toSet());
	}
}

abstract class AircraftCreator {
	static final Random numberCreator = new Random();
	static final int MIN_WEIGHT = 100;
	static final int MAX_CAPACITY = 100;
	static final int MAX_WEIGHT = 100500;
	static final int MAX_RANGE = 100500;
	static final int MIN_RANGE = 100;

	public abstract Aircraft create(int i);

	FuelTank createFuelTank() {
		return new FuelTank(numberCreator.nextInt(MAX_CAPACITY) + MIN_WEIGHT);
	}

	Storage createStorage() {
		return new Storage(numberCreator.nextInt(MAX_CAPACITY), numberCreator.nextInt());
	}

	PassengerLounge createPassengerLounge() {
		return new PassengerLounge(createSeats(numberCreator.nextInt(MAX_CAPACITY)));
	}

	Set<Seat> createSeats(int seatsCount) {
		Set<Seat> seats = new HashSet<>();
		for (int i = 0; i < seatsCount; i++) {
			seats.add(new Seat("" + i));
		}
		return seats;
	}
}

class HelicopterCreator extends AircraftCreator{

	@Override
	public Aircraft create(int i) {
		Helicopter helicopter = new Helicopter("HH" + i, numberCreator.nextInt(MAX_WEIGHT) + MIN_WEIGHT, numberCreator.nextInt(MAX_RANGE)+MIN_RANGE,
				createFuelTank(), createPassengerLounge());
		helicopter.setFuelConsumption(numberCreator.nextInt(MAX_CAPACITY)+1);
		return helicopter;
	}
}

class PlaneCreator extends AircraftCreator{

	@Override
	public Aircraft create(int i) {
		Plane plane = new Plane("CC" + i, numberCreator.nextInt(MAX_WEIGHT) + MIN_WEIGHT, numberCreator.nextInt(MAX_RANGE)+MIN_RANGE,
				createFuelTank(), createStorage());
		plane.setFuelConsumption(numberCreator.nextInt(MAX_CAPACITY)+1);
		return plane;
	}
}

class PassengerPlaneCreator extends AircraftCreator{

	@Override
	public Aircraft create(int i) {
		PassengerPlane plane = new PassengerPlane("PP" + i, numberCreator.nextInt(MAX_WEIGHT) + MIN_WEIGHT,numberCreator.nextInt(MAX_RANGE)+MIN_RANGE,
				createFuelTank(), createStorage(), createPassengerLounge());
		plane.setFuelConsumption(numberCreator.nextInt(MAX_CAPACITY)+1);
		return plane;
	}
}
