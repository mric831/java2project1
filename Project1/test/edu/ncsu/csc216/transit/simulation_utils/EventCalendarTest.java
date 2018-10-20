package edu.ncsu.csc216.transit.simulation_utils;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.transit.airport.TransitGroup;
import edu.ncsu.csc216.transit.airport.entrance.PreSecurity;
import edu.ncsu.csc216.transit.airport.security.SecurityArea;

import edu.ncsu.csc216.transit.airport.travelers.OrdinaryPassenger;
import edu.ncsu.csc216.transit.airport.travelers.Passenger;
/**
 * Tests the functionality of event calendar objects
 * @author Max Richgruber
 *
 */
public class EventCalendarTest {
	/**
	 * Tests the eventcalendar constructor
	 */
	@Test
	public void testEventCalendar() {
		Reporter r = new Log();
		TransitGroup t = new PreSecurity(3, r);
		TransitGroup u = new SecurityArea(3);
		EventCalendar e = new EventCalendar(t, u);
		assertNotNull(e);
	}
	/**
	 * Tests the method that determines which passenger is next to move in the simulation
	 */
	@Test
	public void testNextToAct() {
		Reporter r = new Log();
		PreSecurity p = new PreSecurity(1, r);
		SecurityArea s = new SecurityArea(3);
		Passenger test1 = new OrdinaryPassenger(0, 10, r);
		EventCalendar e = new EventCalendar(p, s);
		try {
			e.nextToAct();
		} catch(IllegalArgumentException y) {
			assertEquals(y.getMessage(), "No remainingPassengers");
		}
		assertEquals(p.nextToGo(), e.nextToAct());
		s.addToLine(0, test1);
		assertEquals(s.nextToGo(), e.nextToAct());
		s.removeNext();
		Passenger test2 = new OrdinaryPassenger(21, 21, r);
		s.addToLine(0, test2);
		//assertEquals(p.nextToGo(), e.nextToAct());
		
		
	}

}
