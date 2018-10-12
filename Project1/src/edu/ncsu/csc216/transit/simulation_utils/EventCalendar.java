package edu.ncsu.csc216.transit.simulation_utils;

import edu.ncsu.csc216.transit.airport.TransitGroup;
import edu.ncsu.csc216.transit.airport.travelers.Passenger;
/**
 * Class that determines which passenger is to move next
 * @author Max Richgruber
 *
 */
public class EventCalendar {
	/**
	 * EventCalendar constructor
	 * @param t interface that tracks high priority passengers
	 * @param u interface that tracks low priority passengers
	 */
	public EventCalendar(TransitGroup t, TransitGroup u){
		
	}
	/**
	 * Get the next passenger to act
	 * @return the passenger that is going to move next
	 */
	public Passenger nextToAct() {
		return null;
	}
}
