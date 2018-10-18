package edu.ncsu.csc216.transit.airport.security;

import edu.ncsu.csc216.transit.airport.travelers.Passenger;
import edu.ncsu.csc216.transit.airport.travelers.PassengerQueue;
/**
 * Class that describes checkpoint objects
 * @author Max Richgruber
 *
 */
public class CheckPoint {
	/** The checkpoint line */
	private PassengerQueue line;
	/** The time when the checkpoint becomes available */
	private int timeWhenAvailable;
	/**
	 * Constructor for the checkpoint object
	 */
	public CheckPoint(){
		
	}
	/**
	 * Gets the size of the checkpoint line
	 * @return size of the line
	 */
	public int size() {
		return 0;
	}
	/**
	 * Removes a passenger from the checkpoint line
	 * @return the passenger that was removed from the line
	 */
	public Passenger removeFromLine() {
		return null;
	}
	/**
	 * Determine if there is a passenger remaining in the line
	 * @return whether there is still a passenger in the checkpoint line
	 */
	public boolean hasNext() {
		return false;
	}
	/**
	 * Gets the depart time of the next passenger in line
	 * @return the next depart time
	 */
	public int departTimeNext() {
		return 0;
	}
	/**
	 * Gets the next passenger in line
	 * @return the passenger that was up next in the checkpoint line
	 */
	public Passenger nextToGo() {
		return null;
	}
	/**
	 * Adds a passenger to the checkpoint line
	 * @param p the passenger to be added to the line
	 */
	public void addToLine(Passenger p) {
		
	}
}
