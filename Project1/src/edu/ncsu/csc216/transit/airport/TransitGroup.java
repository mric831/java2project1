package edu.ncsu.csc216.transit.airport;

import edu.ncsu.csc216.transit.airport.travelers.Passenger;

public interface TransitGroup {
	
	public static Passenger nextToGo() {
		return null;
	}
	
	public static int departTimeNext() {
		return 0;
	}
	
	public static Passenger removeNext() {
		return null;
	}
}
