package edu.ncsu.csc216.transit.simulation_utils;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.transit.airport.TransitGroup;
import edu.ncsu.csc216.transit.airport.entrance.PreSecurity;
import edu.ncsu.csc216.transit.airport.security.SecurityArea;
import edu.ncsu.csc216.transit.airport.travelers.FastTrackPassenger;
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
		Passenger test1 = new FastTrackPassenger(-1, 20, r);
		Passenger test2 = new FastTrackPassenger(Integer.MAX_VALUE, 20, r);
		EventCalendar e = new EventCalendar(p, s);
		p.removeNext();
		try {
			e.nextToAct();
		} catch(IllegalArgumentException y) {
			assertEquals(y.getMessage(), "No remaining passengers");
		}
		p = new PreSecurity(1, r);
		s.addToLine(0, test1);
		assertTrue(e.nextToAct() instanceof FastTrackPassenger);
		s.removeNext();
		s.addToLine(0, test2);
		assertTrue(e.nextToAct() instanceof Passenger);
		s.removeNext();
		
		
	}

}
