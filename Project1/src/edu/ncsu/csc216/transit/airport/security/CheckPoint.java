package edu.ncsu.csc216.transit.airport.security;

import edu.ncsu.csc216.transit.airport.travelers.Passenger;

public class CheckPoint {

	private int timeWhenAvailable;
	
	CheckPoint(){
		
	}
	
	public int size() {
		return 0;
	}
	
	public Passenger removeFromLine() {
		return null;
	}
	
	public boolean hasNext() {
		return false;
	}
	
	public int departTimeNext() {
		return 0;
	}
	
	public Passenger nextToGo() {
		return null;
	}
	
	public void addToLine(Passenger p) {
		
	}
}
