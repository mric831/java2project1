package edu.ncsu.csc216.transit.airport.travelers;

import java.awt.Color;

import edu.ncsu.csc216.transit.airport.TransitGroup;
import edu.ncsu.csc216.transit.simulation_utils.Reporter;
/**
 * Class that describes FastTrackPassenger objects
 * @author Max Richgruber
 *
 */
public class FastTrackPassenger extends Passenger {
	/** The maximum amount of time to process the passenger */
	private static final int MAX_EXPECTED_PROCESS_TIME = 0;
	/** A color representation of the passenger */
	private Color color;
	/**
	 * Constructor for FastTrackPassenger objects
	 * @param i the passenger's arrival time
	 * @param j the passenger's process time
	 * @param r reports information about the passenger
	 */
	FastTrackPassenger(int i, int j, Reporter r){
		super(j, j, r);
	}
	/**
	 * Moves the passenger to a checkpoint line
	 * @param t interface to move passengers
	 */
	public void getInLine(TransitGroup t) {
		
	}
	/**
	 * Gets the passenger's color representation
	 * @return the passenger's color
	 */
	public Color getColor() {
		return null;
	}
	/**
	 * Picks the checkpoint line for the passenger to move to
	 * @param t interface to move passengers
	 * @return the checkpoint line the passenger is going to move to
	 */
	private int pickLine(TransitGroup t) {
		return 0;
	}
}
