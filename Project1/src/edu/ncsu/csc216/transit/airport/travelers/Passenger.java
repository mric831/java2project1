package edu.ncsu.csc216.transit.airport.travelers;

import java.awt.Color;

import edu.ncsu.csc216.transit.airport.TransitGroup;
import edu.ncsu.csc216.transit.simulation_utils.Reporter;
/**
 * Abstract class that describes the behavior of Passenger objects
 * @author Max Richgruber
 *
 */
public abstract class Passenger {
	/** minimum amount of time for a passenger to be processed */
	public static final int MIN_PROCESS_TIME = 20;
	/** time the passenger is going to arrive */
	private int arrivalTime;
	/** how long the passenger has to wait */
	private int waitTime;
	/** how long it takes for the passenger to be processed */
	private int processTime;
	/** index of the passenger's line */
	private int lineIndex;
	/** the passenger's current state waiting/processing */
	private boolean waitingProcessing;
	/** reporter for the passenger */
	private Reporter myLog;
	/**
	 * Constructor for the passenger objects
	 * @param arrival the passenger's arrival time
	 * @param process the passenger's process time
	 * @param log reports information about the passenger
	 */
	public Passenger(int arrival, int process, Reporter log){
		this.processTime = process;
		this.arrivalTime = arrival;
		this.myLog = log;
		waitingProcessing = false;
		
	}
	/**
	 * Gets the passenger's arrival time
	 * @return arrival time
	 */
	public int getArrivalTime() {
		return arrivalTime;
	}
	/**
	 * Gets the passenger's waiting time
	 * @return wait time
	 */
	public int getWaitTime() {
		
		return waitTime;
	}
	/**
	 * Sets the wait time of the specified passenger
	 * @param i the time for the wait time to be set to
	 */
	public void setWaitTime(int i) {
		if(i >= 0) {
			this.waitTime = i;
		} else {
			throw new IllegalArgumentException("Invalid Wait Time");
		}
		
	}
	/**
	 * Gets the amount of time it takes for the passenger to be processed
	 * @return process time
	 */
	public int getProcessTime() {
		return processTime;
	}
	/**
	 * Gets the index of the line the passenger is in
	 * @return index of the line 
	 */
	public int getLineIndex() {
		return lineIndex;
	}
	/**
	 * Determine whether or not the passenger is in a security line
	 * @return if the passenger is in line
	 */
	public boolean isWaitingInSecurityLine() {
		return waitingProcessing;
	}
	/**
	 * Moves the passenger out of a security checkpoint when processed
	 */
	public void clearSecurity() {
		waitingProcessing = false;
		this.setLineIndex(-1);
		myLog.logData(this);
	}
	/**
	 * Sets the passenger's line to the specified index
	 * @param i the index to set lineIndex of the passenger to
	 */
	protected void setLineIndex(int i) {
		if(i != -1) {
			this.waitingProcessing = true;
		}
		this.lineIndex = i;
	}
	/**
	 *  Moves a passenger to a line 
	 * @param t the TransitGroup used to move the passenger 
	 */
	public abstract void getInLine(TransitGroup t);
	/** 
	 * Gets the passenger's color 
	 * @return color of the passenger
	 */
	public abstract Color getColor();
}
