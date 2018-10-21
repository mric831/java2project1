package edu.ncsu.csc216.transit.simulation_utils;

import edu.ncsu.csc216.transit.airport.TransitGroup;
import edu.ncsu.csc216.transit.airport.travelers.Passenger;
/**
 * Class that determines which passenger is to move next
 * @author Max Richgruber
 *
 */
public class EventCalendar {
	/**High priority passengers */
	private TransitGroup high;
	/**High priority passengers */
	private TransitGroup low;
	/**
	 * EventCalendar constructor
	 * @param high interface that tracks high priority passengers
	 * @param low interface that tracks low priority passengers
	 */
	public EventCalendar(TransitGroup high, TransitGroup low){
		this.high = high;
		this.low = low;
	}
	/**
	 * Get the next passenger to act
	 * @return the passenger that is going to move next
	 */
	public Passenger nextToAct() {
		
		if(high.departTimeNext() == Integer.MAX_VALUE && low.departTimeNext() == Integer.MAX_VALUE) {
			throw new IllegalStateException();
		}
		if(high.departTimeNext() < low.departTimeNext()) {
			return high.nextToGo();
		} else if(low.departTimeNext() < high.departTimeNext()) {
			return low.nextToGo();
		}
		return high.nextToGo();

	}
}
