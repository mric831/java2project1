package edu.ncsu.csc216.transit.airport.travelers;

import java.awt.Color;

import edu.ncsu.csc216.transit.airport.TransitGroup;
import edu.ncsu.csc216.transit.simulation_utils.Reporter;

public abstract class Passenger {

	private static final int MIN_PROCESS_TIME = 0;
	private int arrivalTime;
	private int waitTime;
	private int processTime;
	private int lineIndex;
	private boolean waitingProcessing;
	
	Passenger(int i, int j, Reporter r){
		
	}
	
	public int getArrivalTime() {
		return 0;
	}
	
	public int getWaitTime() {
		return 0;
	}
	
	public void setWaitTime(int i) {
		
	}
	
	public int getProcessTime() {
		return 0;
	}
	
	public int getLineIndex() {
		return 0;
	}
	
	public boolean isWaitingInSecurityLine() {
		return false;
	}
	
	public void clearSecurity() {
		
	}
	
	protected void setLineIndex() {
		
	}
	
	public abstract void getInLine(TransitGroup t);
	
	public abstract Color getColor();
}
