package edu.ncsu.csc216.transit.airport.entrance;

import java.util.NoSuchElementException;

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
		if(passengers <= 0) {
			throw new IllegalArgumentException("Number of passengers must be positive.");
		}
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
		if(outsideSecurity.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		Passenger p = outsideSecurity.front();
		return p.getArrivalTime();
	}
	/**
	 * Gets the passenger that is up next
	 * @return the next passenger
	 */
	public Passenger nextToGo() {
		return outsideSecurity.front();
	}
	/**
	 * Checks if there is a next passenger
	 * @return whether there is a next passenger or not
 	 */
	public boolean hasNext() {
		if(outsideSecurity.isEmpty()) {
			return false;
		}
		return true;
	}
	/**
	 * Removes the next passenger in the queue
	 * @return passenger that was removed
	 */
	public Passenger removeNext() {
		if(!(this.hasNext())) {
			throw new NoSuchElementException("No passengers to remove");
		}
		return outsideSecurity.remove();
	}
}
