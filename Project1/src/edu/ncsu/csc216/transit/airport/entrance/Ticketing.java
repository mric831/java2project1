package edu.ncsu.csc216.transit.airport.entrance;

import java.util.Random;

import edu.ncsu.csc216.transit.airport.travelers.Passenger;
import edu.ncsu.csc216.transit.simulation_utils.Reporter;
/**
 * Class that describes the states and behaviors of ticketing objects
 * @author Max Richgruber
 *
 */
public class Ticketing {
	/** Time for the passenger at ticketing */
	private static int time;
	/** Used for the generation of random times */
	private static Random randomNumber;
	/** Delay between generations */
	private static final double MAX_GENERATION_DELAY = 0.0;
	/** Percentage of passengers who are fast track */
	private static double pctExpedite;
	/** Percentage of passengers who are trusted travelers */
	private static double pctTrust;
	/**
	 * Constructor for Ticketing objects 
	 */
	Ticketing(){
		
	}
	/**
	 * Sets the distribution of passenger types
	 * @param a percentage of fast track passengers
	 * @param b percentage of trusted travelers
	 */
	public static void setDistribution(int a, int b) {
		
	}
	/**
	 * Generates a new passenger
	 * @param r Reporter that tracks information about passengers
	 * @return the passenger that was generated
	 */
	public static Passenger generatePassenger(Reporter r) {
		return null;
	}
	/**
	 * Resets the simulation
	 */
	public static void resetFactory() {
		
	}
	
}
