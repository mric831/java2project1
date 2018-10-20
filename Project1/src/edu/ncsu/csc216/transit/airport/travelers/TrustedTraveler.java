package edu.ncsu.csc216.transit.airport.travelers;

import java.awt.Color;

import edu.ncsu.csc216.transit.airport.TransitGroup;
import edu.ncsu.csc216.transit.airport.security.SecurityArea;
import edu.ncsu.csc216.transit.simulation_utils.Reporter;
/**
 * Class that describes TrustedTraveler objects
 * @author Max Richgruber
 *
 */
public class TrustedTraveler extends Passenger {
	/** The maximum amount of time to process the passenger */
	public static final int MAX_EXPECTED_PROCESS_TIME = 180;
	/** A color representation of the passenger */
	private Color color;
	/**
	 * Constructor for TrustedTraveler objects
	 * @param arrival the passenger's arrival time
	 * @param process the passenger's process time
	 * @param r reports information about the passenger
	 */
	public TrustedTraveler(int arrival, int process, Reporter r){
		super(arrival, process, r);
		if(getProcessTime() < MAX_EXPECTED_PROCESS_TIME/2) {
			color = new Color(153,255,153);
		} else {
			color = new Color(0,255,0);
		}
	}
	/**
	 * Moves the passenger to a checkpoint line
	 * @param t interface to move passengers
	 */
	public void getInLine(TransitGroup t) {
		int line = pickLine(t);
		this.setLineIndex(line);
		SecurityArea s = (SecurityArea) t;
		s.addToLine(line, this);
		this.isWaitingInSecurityLine();
		
	}
	/**
	 * Gets the passenger's color representation
	 * @return the passenger's color
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * Picks the checkpoint line for the passenger to move to
	 * @param t interface to move passengers
	 * @return the checkpoint line the passenger is going to move to
	 */
	private int pickLine(TransitGroup t) {
		SecurityArea s = (SecurityArea) t;
		int trustedLine = s.shortestTSAPreLine();
		int trustedSize = s.lengthOfLine(trustedLine);
		int ordinaryLine = s.shortestRegularLine();
		int ordinarySize = s.lengthOfLine(ordinaryLine);
		if(trustedSize >= ordinarySize * 2) {
			this.setLineIndex(ordinaryLine);
			return ordinaryLine;
		} else {
			this.setLineIndex(trustedLine);
			return trustedLine;
		}
	}
}
