package edu.ncsu.csc216.transit.airport;

import edu.ncsu.csc216.transit.airport.travelers.Passenger;
/**
 * An interface that facilitates the processing of passengers
 * @author Max Richgruber
 *
 */
public interface TransitGroup {
	/**
	 * Determines the next passenger to go
	 * @return next passenger in line
	 */
	public static Passenger nextToGo() {
		return null;
	}
	/**
	 * Gets the depart time of the next passenger
	 * @return next passenger's depart time
	 */
	public static int departTimeNext() {
		return 0;
	}
	/**
	 * Removes the next passenger in line when correctly moved
	 * @return the passenger that was removed 
	 */
	public static Passenger removeNext() {
		return null;
	}
}
