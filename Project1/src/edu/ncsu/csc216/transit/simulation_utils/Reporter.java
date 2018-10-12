package edu.ncsu.csc216.transit.simulation_utils;

import edu.ncsu.csc216.transit.airport.travelers.Passenger;
/**
 * Interface that tracks passenger's information
 * @author Max Richgruber
 *
 */
public interface Reporter {
	/**
	 * Gets the number of fully processed passengers
	 * @return number of processed passengers
	 */
	public static int getNumCompleted() {
		return 0;
	}
	/**
	 * Adds a passenger's information to a log
	 * @param p the Passenger being logged
	 */
	public static void logData(Passenger p) {
		
	}
	/**
	 * Calculates the average waiting time of all passengers
	 * @return average wait time
	 */
	public static double averageWaitTime() {
		return 0;
	}
	/**
	 * Calculates the average processing time of all passengers
	 * @return average process time
	 */
	public static double averageProcessTime() {
		return 0;
	}
}
