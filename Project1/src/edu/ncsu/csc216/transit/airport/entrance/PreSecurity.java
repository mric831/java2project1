package edu.ncsu.csc216.transit.airport.entrance;

import edu.ncsu.csc216.transit.airport.TransitGroup;
import edu.ncsu.csc216.transit.airport.travelers.Passenger;
import edu.ncsu.csc216.transit.airport.travelers.PassengerQueue;
import edu.ncsu.csc216.transit.simulation_utils.Reporter;
/**
 * Object that handles passengers between ticketing and security
 * @author Max Richgruber
 *
 */
public class PreSecurity implements TransitGroup {
	/** Passengers not in a security checkpoint */
	private PassengerQueue outsideSecurity;
	/**
	 * PreSecurity constructor
	 * @param passengers number of passengers
	 * @param log Reporter describing passenger information
	 */
	public PreSecurity(int passengers, Reporter log){
		this.outsideSecurity = new PassengerQueue();
		Passenger p = null;
		for(int i = 0; i < passengers; i++) {
			p = Ticketing.generatePassenger(log);
			outsideSecurity.add(p);
		}
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
