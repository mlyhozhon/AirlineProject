package com.tvorobiova.airline.airplane.storage;

import java.util.ArrayList;
import java.util.List;

public class Storage {

	private final int maxWeightCapacity;
	private final int maxVolumeCapacity;

	private List<Cargo> cargoList;

	public Storage(int maxWeightCapacity, int maxVolumeCapacity) {
		this.maxWeightCapacity = maxWeightCapacity;
		this.maxVolumeCapacity = maxVolumeCapacity;
	}

	public boolean loadCargo(Cargo cargo) {
		if (cargoList == null) {
			cargoList = new ArrayList<Cargo>();
		}
		if (isValidForLoading(cargo)) {
			cargoList.add(cargo);
			return true;
		}
		return false;
	}

	public boolean removeCargo(Cargo cargo) {
		if (cargoList != null) {
			return cargoList.remove(cargo);
		}
		return false;
	}

	private int calculateTotalVolume() {
		return 0;
	}

	private int calculateTotalWeight() {
		return 0;
	}

	public int countTotalCapacity() {
		int totalCapacity = 0;
		if (cargoList != null) {
			for (Cargo cargo : cargoList) {
				totalCapacity += cargo != null ? cargo.getWeight() : 0;
			}
		}
		return totalCapacity;
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
