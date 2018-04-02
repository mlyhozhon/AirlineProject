package com.tvorobiova.airline.airplane.storage;

public class Cargo {

	private int volume;
	private int weight;
	
	public Cargo() {}
	
	public Cargo(int volume, int weight){
		this.volume = volume;
		this.weight = weight;
	}
	
	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeightCapacity(int weight) {
		this.weight = weight;
	}
	
	
}
