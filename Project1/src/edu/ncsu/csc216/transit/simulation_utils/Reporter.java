package edu.ncsu.csc216.transit.simulation_utils;

import edu.ncsu.csc216.transit.airport.travelers.Passenger;

public interface Reporter {

	public static int getNumCompleted() {
		return 0;
	}
	
	public static void logData(Passenger p) {
		
	}
	
	public static double averageWaitTime() {
		return 0;
	}
	
	public static double averageProcessTime() {
		return 0;
	}
}
