package edu.ncsu.csc216.transit.airport.entrance;

import edu.ncsu.csc216.transit.airport.TransitGroup;
import edu.ncsu.csc216.transit.airport.travelers.Passenger;
import edu.ncsu.csc216.transit.simulation_utils.Reporter;
/**
 * Object that handles passengers between ticketing and security
 * @author Max Richgruber
 *
 */
public class PreSecurity implements TransitGroup {
	/**
	 * PreSecurity constructor
	 * @param i depart time of a passenger
	 * @param r Reporter describing passenger information
	 */
	PreSecurity(int i, Reporter r){
		
	}
	/**
	 * Gets the depart time of the next passenger
	 * @return next passenger's depart time
	 */
	public int departTimeNext() {
		return 0;
	}
	/**
	 * Gets the passenger that is up next
	 * @return the next passenger
	 */
	public Passenger nextToGo() {
		return null;
	}
	/**
	 * Checks if there is a next passenger
	 * @return whether there is a next passenger or not
 	 */
	public boolean hasNext() {
		return false;
	}
	/**
	 * Removes the next passenger in the queue
	 * @return passenger that was removed
	 */
	public Passenger removeNext() {
		return null;
	}
}
