package edu.ncsu.csc216.transit.simulation_utils;

import java.awt.Color;

import edu.ncsu.csc216.transit.airport.TransitGroup;
import edu.ncsu.csc216.transit.airport.entrance.PreSecurity;
import edu.ncsu.csc216.transit.airport.entrance.Ticketing;
import edu.ncsu.csc216.transit.airport.security.SecurityArea;
import edu.ncsu.csc216.transit.airport.travelers.Passenger;
/**
 * Class that runs the simulation
 * @author Max Richgruber
 *
 */
public class Simulator {
	/** Number of passengers in the simulation */
	private int numPassengers;
	/** Log that keeps track of passenger information*/
	private Reporter log;
	/** Current passenger of the simulation */
	private Passenger currentPassenger;
	/** Event Calendar that determines the next passenger of the simulation */
	private EventCalendar myCalendar;
	/** Passengers in the security lines */
	private TransitGroup inSecurity;
	/** Passenger in the ticketing line */
	private TransitGroup inTicketing;
	/**
	 * Constructor of the simulator
	 * @param checkpoints number of security checkpoints
	 * @param passengers number of passengers
	 * @param trustedPCT percentage of trusted travelers
	 * @param fastPCT percentage of fast track passengers 
	 * @param ordinaryPCT percentage of ordinary passengers
	 */
	public Simulator(int checkpoints, int passengers, int trustedPCT, int fastPCT, int ordinaryPCT){
		checkParameters(checkpoints, passengers, trustedPCT, fastPCT, ordinaryPCT);
		this.log = new Log();
		setUp(passengers, trustedPCT, fastPCT);
		inSecurity = new SecurityArea(checkpoints);
		myCalendar = new EventCalendar(inTicketing, inSecurity);
		numPassengers = passengers;
	}
	/**
	 * Checks the provided information of the simulation
	 * @param checkpoints number of security checkpoints
	 * @param passengers number of passengers
	 * @param trustedPCT percentage of trusted travelers
	 * @param fastPCT percentage of fast track passengers 
	 * @param ordinaryPCT percentage of ordinary passengers
	 */
	private void checkParameters(int checkpoints, int passengers, int trustedPCT, int fastPCT, int ordinaryPCT) {
		if(passengers < 1) {
			throw new IllegalArgumentException("There must be at least one passenger.");
		}
		if((trustedPCT + fastPCT + ordinaryPCT) != 100) {
			throw new IllegalArgumentException("Percents must sum to 100.");
		}
	}
	/**
	 * Sets up the passengers of the simulation
	 * @param passengers number of passengers
	 * @param trustedPCT percentage of trusted passengers
	 * @param fastPCT percentage of fast track travelers
	 */
	private void setUp(int passengers, int trustedPCT, int fastPCT) {
		Ticketing.setDistribution(trustedPCT, fastPCT);
		inTicketing = new PreSecurity(passengers, log);
		
	}
	/**
	 * Accesses the reporter interface
	 * @return reporter interface that describes passengers
	 */
	public Reporter getReporter() {
		return log;
	}
	/**
	 * Increments the simulation
	 */
	public void step() {
		if(moreSteps()) {
			currentPassenger = myCalendar.nextToAct();
			if(currentPassenger.isWaitingInSecurityLine()) {
				currentPassenger.clearSecurity();
				SecurityArea s = (SecurityArea) inSecurity;
				s.removeNext();

			} else {
				currentPassenger.getInLine(inSecurity);
				PreSecurity p = (PreSecurity) inTicketing;
				p.removeNext();
			}
		} 
		
	}
	/**
	 * Determines if the simulation continues
	 * @return whether or not the simulation continues
	 */
	public boolean moreSteps() {
		if(inSecurity.nextToGo() == null && inTicketing.nextToGo() == null && log.getNumCompleted() == numPassengers) {
			return false;
		}
		return true;
		
		
	}
	/**
	 * Gets the current index of the passenger
	 * @return current index
	 */
	public int getCurrentIndex() {
		if(currentPassenger == null) {
			return -1;
		}
		return currentPassenger.getLineIndex();
	}
	/**
	 * Gets the color of the current Passenger
	 * @return current passenger color
	 */
	public Color getCurrentPassengerColor() {
		if(currentPassenger == null) {
			return null;
		}
		return currentPassenger.getColor();
	}
	/**
	 * If a passenger has cleared security
	 * @return whether or not the passenger cleared security
	 */
	public boolean passengerClearedSecurity() {
		if(currentPassenger == null) {
			return false;
		}
		if(currentPassenger.isWaitingInSecurityLine() || currentPassenger.equals(inTicketing.nextToGo())) {
			return false;
		}
		return true;

	}
}
