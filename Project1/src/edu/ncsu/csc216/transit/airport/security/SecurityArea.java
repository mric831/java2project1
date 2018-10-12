package edu.ncsu.csc216.transit.airport.security;

import edu.ncsu.csc216.transit.airport.TransitGroup;
import edu.ncsu.csc216.transit.airport.travelers.Passenger;
/**
 * Class that describes the pool of security checkpoints
 * @author Max Richgruber
 *
 */
public class SecurityArea implements TransitGroup {
	/** Maximum number of checkpoints */
	private static final int MAX_CHECKPOINTS = 0;
	/** Minimum number of checkpoints */
	private static final int MIN_CHECKPOINTS = 0;
	/** Error with checkpoints */
	private static final String ERROR_CHECKPOINTS = "";
	/** Error with a checkpoint index */
	private static final String ERROR_INDEX = "";
	/** Largest index of anyy Fast Track Checkpoint */
	private int largestFastIndex;
	/** The index of the Trusted Traveler Checkpoint */
	private int tsaPreIndex;
	/**
	 * Constructor of the SecurityArea object
	 * @param i number of checkpoints
	 */
	SecurityArea(int i){
		
	}
	/**
	 * Determines if the number of checkpoints is valid
	 * @param i number of checkpoints
	 * @return Whether the created number of checkpoints is valid
	 */
	private boolean numGatesOK(int i) {
		return false;
	}
	/**
	 * Add a passenger to a checkpoint line
	 * @param i index of the line to add to
	 * @param p the passenger to be added
	 */
	public void addToLine(int i, Passenger p) {
		
	}
	/**
	 * Gets the shortest regular line
	 * @return index of the shortest regular line
	 */
	public int shortestRegularLine() {
		return 0;
	}
	/**
	 * Gets the shortest fast track line
	 * @return index of the shortest fast track line
	 */
	public int shortestFastTrackLine() {
		return 0;
	}
	/**
	 * Gets the shortest trusted traveler line
	 * @return index of the shortest trusted traveler line
	 */
	public int shortestTSAPreLine() {
		return 0;
	}
	/**
	 * Gets the length of the line
	 * @param i index of the line to be checked
	 * @return length of the specified line
	 */
	public int lengthOfLine(int i) {
		return 0;
	}
	/**
	 * Gets the depart time of the next passenger
	 * @return the next depart time
	 */
	public int departTimeNext() {
		return 0;
	}
	/**
	 * Gets the next passenger to go
	 * @return the next passenger
	 */
	public Passenger nextToGo() {
		return null;
	}
	/**
	 * Removes the passenger that is up next
	 * @return the passenger that was removed
	 */
	public Passenger removeNext() {
		return null;
	}
	/**
	 * Gets the shortest line in a range 
	 * @param i index to start the range
	 * @param j index to end the range
	 * @return shortest line in the provided range
	 */
	private int shortestLineInRange(int i, int j) {
		return 0;
	}
	/**
	 * Gets the line that is going to clear a passenger next
	 * @return index of the next line to clear a passnger
	 */
	private int lineWithNextToClear() {
		return 0;
	}
	
	
	
}
