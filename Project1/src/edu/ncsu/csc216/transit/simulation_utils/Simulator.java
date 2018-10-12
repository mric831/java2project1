package edu.ncsu.csc216.transit.simulation_utils;

import java.awt.Color;
/**
 * Class that runs the simulation
 * @author Max Richgruber
 *
 */
public class Simulator {
	/** Number of passengers in the simulation */
	private int numPassengers;
	/**
	 * Constructor of the simulator
	 * @param a number of passengers
	 * @param b number of security checkpoints
	 * @param c percentage of ordinary passengers
	 * @param d percentage of fast track passengers
	 * @param e percentage of trusted travelers
	 */
	public Simulator(int a, int b, int c, int d, int e){
		
	}
	/**
	 * Checks the provided information of the simulation
	 * @param a number of passengers
	 * @param b number of security checkpoints
	 * @param c percentage of ordinary passengers
	 * @param d percentage of fast track passengers
	 * @param e percentage of trusted travelers
	 */
	private void checkParameters(int a, int b, int c, int d, int e) {
		
	}
	/**
	 * Sets up the passengers of the simulation
	 * @param a percentage of ordinary passengers
	 * @param b percentage of fast track passengers
	 * @param c percentage of trusted travelers
	 */
	private void setUp(int a, int b, int c) {
		
	}
	/**
	 * Accesses the reporter interface
	 * @return reporter interface that describes passengers
	 */
	public Reporter getReporter() {
		return null;
	}
	/**
	 * Increments the simulation
	 */
	public void step() {
		
	}
	/**
	 * Determines if the simulation continues
	 * @return whether or not the simulation continues
	 */
	public boolean moreSteps() {
		return false;
	}
	/**
	 * Gets the current index of the simulation
	 * @return current index
	 */
	public int getCurrentIndex() {
		return 0;
	}
	/**
	 * Gets the color of the current Passenger
	 * @return current passenger color
	 */
	public Color getCurrentPassengerColor() {
		return null;
	}
	/**
	 * If a passenger has cleared security
	 * @return whether or not the passenger cleared security
	 */
	public boolean passengerClearedSecurity() {
		return false;
	}
}
