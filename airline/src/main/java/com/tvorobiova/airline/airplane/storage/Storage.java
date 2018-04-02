package com.tvorobiova.airline.airplane.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Storage {

	private final int maxWeightCapacity;
	private final int maxVolumeCapacity;

	private List<Cargo> cargoList = new ArrayList<>();

	public Storage(int maxWeightCapacity, int maxVolumeCapacity) {
		this.maxWeightCapacity = maxWeightCapacity;
		this.maxVolumeCapacity = maxVolumeCapacity;
	}

	public boolean loadCargo(Cargo cargo) {
		return isValidForLoading(cargo) && cargoList.add(cargo);
	}

	public boolean removeCargo(Cargo cargo) {
		return cargoList.remove(cargo);
	}

	private int calculateTotalVolume() {
		return 0;
	}

	private int calculateTotalWeight() {
		return 0;
	}

	public int countTotalCapacity() {
		return cargoList.stream()
				.filter(Objects::nonNull)
				.map(Cargo::getWeight)
				.reduce(0, Integer::sum);
	}

	private boolean isValidForLoading(Cargo cargo) {
		return (calculateTotalWeight() + cargo.getWeight() <= maxWeightCapacity)
				&& (calculateTotalVolume() + cargo.getVolume() <= maxVolumeCapacity);
	}

	public int getMaxWeightCapacity() {
		return maxWeightCapacity;
	}

	public int getMaxVolumeCapacity() {
		return maxVolumeCapacity;
	}

	public List<Cargo> getCargoList() {
		return cargoList;
	}

	public void setCargoList(List<Cargo> cargoList) {
		this.cargoList = cargoList;
	}

}
