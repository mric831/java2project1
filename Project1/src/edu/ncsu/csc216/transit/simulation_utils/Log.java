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
	public Log(){
		numCompleted = 0;
		totalWaitTime = 0;
		totalProcessTime = 0;
	}
	/**
	 * Gets the number of completed passengers
	 * @return number of completed passengers
	 */
	public int getNumCompleted() {
		return numCompleted;
	}
	/**
	 * Logs the data of the provided passenger
	 * @param p Passenger to log
	 */
	public void logData(Passenger p) {
		totalWaitTime += p.getWaitTime();
		totalProcessTime += p.getProcessTime();
		numCompleted++;
	}
	/**
	 * Calculates average wait time of all passengers
	 * @return average wait time
	 */
	public double averageWaitTime() {
		if(numCompleted == 0) {
			return 0.0;
		}
		return (totalWaitTime / (double) numCompleted) / 60;
	}
	/**
	 * Calculates average process time of all passengers
	 * @return average process time
	 */
	public double averageProcessTime() {
		if(numCompleted == 0) {
			return 0.0;
		}
		return (totalProcessTime / (double) numCompleted) / 60;
	}
}
