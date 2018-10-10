package edu.ncsu.csc216.transit.airport.entrance;

import edu.ncsu.csc216.transit.airport.travelers.Passenger;
import edu.ncsu.csc216.transit.simulation_utils.Reporter;

public class PreSecurity {

	PreSecurity(int i, Reporter r){
		
	}
	
	public int departTimeNext() {
		return 0;
	}
	
	public Passenger nextToGo() {
		return null;
	}
	
	public boolean hasNext() {
		return false;
	}
	
	public Passenger removeNext() {
		return null;
	}
}
