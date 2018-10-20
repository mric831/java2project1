package edu.ncsu.csc216.transit.airport.security;

import java.util.NoSuchElementException;

import edu.ncsu.csc216.transit.airport.travelers.Passenger;
import edu.ncsu.csc216.transit.airport.travelers.PassengerQueue;
/**
 * Class that describes checkpoint objects
 * @author Max Richgruber
 *
 */
public class CheckPoint {
	/** The checkpoint line */
	private PassengerQueue line;
	/** The time when the checkpoint becomes available */
	private int timeWhenAvailable;
	/**
	 * Constructor for the checkpoint object
	 */
	public CheckPoint(){
		this.line = new PassengerQueue();
		this.timeWhenAvailable = 0;
	}
	/**
	 * Gets the size of the checkpoint line
	 * @return size of the line
	 */
	public int size() {
		return line.size();
	}
	/**
	 * Removes a passenger from the checkpoint line
	 * @return the passenger that was removed from the line
	 */
	public Passenger removeFromLine() {
		if(!(this.hasNext())) {
			throw new NoSuchElementException("No passengers to remove");
		}
		return line.remove();
	}
	/**
	 * Determine if there is a passenger remaining in the line
	 * @return whether there is still a passenger in the checkpoint line
	 */
	public boolean hasNext() {
		if(line.isEmpty()) {
			return false;
		}
		return true;
	}
	/**
	 * Gets the depart time of the next passenger in line
	 * @return the next depart time
	 */
	public int departTimeNext() {
		if(line.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		Passenger p = this.nextToGo();
		return p.getArrivalTime() + p.getProcessTime() + p.getWaitTime();
	}
	/**
	 * Gets the next passenger in line
	 * @return the passenger that was up next in the checkpoint line
	 */
	public Passenger nextToGo() {
		return line.front();
	}
	/**
	 * Adds a passenger to the checkpoint line
	 * @param p the passenger to be added to the line
	 */
	public void addToLine(Passenger p) {
		if(line.isEmpty()) {
			line.add(p);
			p.setWaitTime(0);
			timeWhenAvailable = p.getArrivalTime() + p.getProcessTime();
		} else {
			line.add(p);
			p.setWaitTime(timeWhenAvailable-p.getArrivalTime());
			timeWhenAvailable += p.getProcessTime();
		}
		
		
	}
}
