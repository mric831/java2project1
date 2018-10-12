package edu.ncsu.csc216.transit.simulation_utils;

import edu.ncsu.csc216.transit.airport.travelers.Passenger;
/**
 * Class that keeps track of passenger information
 * @author Max Richgruber
 *
 */
public class Log implements Reporter {
	/** Number of fully processed passengers */
	private int numCompleted;
	/** Total time spent waiting by a passenger */
	private int totalWaitTime;
	/** Total time spent processing by a passenger */
	private int totalProcessTime;
	/**
	 * Constructor of the Log object
	 */
	Log(){
		
	}
	/**
	 * Gets the number of completed passengers
	 * @return number of completed passengers
	 */
	public int getNumCompleted() {
		return 0;
	}
	/**
	 * Logs the data of the provided passenger
	 * @param p Passenger to log
	 */
	public void logData(Passenger p) {
		
	}
	/**
	 * Calculates average wait time of all passengers
	 * @return average wait time
	 */
	public double averageWaitTime() {
		return 0;
	}
	/**
	 * Calculates average process time of all passengers
	 * @return average process time
	 */
	public double averageProcessTime() {
		return 0;
	}
}
