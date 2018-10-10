package edu.ncsu.csc216.transit.airport.security;

import edu.ncsu.csc216.transit.airport.travelers.Passenger;

public class SecurityArea {

	private static final int MAX_CHECKPOINTS = 0;
	private static final int MIN_CHECKPOINTS = 0;
	private static final String ERROR_CHECKPOINTS = "";
	private static final String ERROR_INDEX = "";
	private int largestFastIndex;
	private int tsaPreIndex;
	
	SecurityArea(int i){
		
	}
	
	private boolean numGatesOK(int i) {
		return false;
	}
	
	public void addToLine(int i, Passenger p) {
		
	}
	
	public int shortestRegularLine() {
		return 0;
	}
	
	public int shortestFastTrackLine() {
		return 0;
	}
	
	public int shortestTSAPreLine() {
		return 0;
	}
	
	public int lengthOfLine(int i) {
		return 0;
	}
	
	public int departTimeNext() {
		return 0;
	}
	
	public Passenger nextToGo() {
		return null;
	}
	
	public Passenger removeNext() {
		return null;
	}
	
	private int shortestLineInRange(int i, int j) {
		return 0;
	}
	
	private int lineWithNextToClear() {
		return 0;
	}
	
	
	
}
