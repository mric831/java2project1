package edu.ncsu.csc216.transit.airport.entrance;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import edu.ncsu.csc216.transit.airport.travelers.Passenger;
import edu.ncsu.csc216.transit.simulation_utils.Log;
import edu.ncsu.csc216.transit.simulation_utils.Reporter;
/**
 * Tests the functionality of Presecurity objects
 * @author Max Richgruber
 *
 */
public class PreSecurityTest {
	/**
	 * Tests presecurity constructor
	 */
	@Test
	public void testPreSecurity() {
		Reporter r = new Log();
		int passengers = 10;
		int count = 0;
		try {
			PreSecurity ticketingLine = new PreSecurity(0, r);
			ticketingLine.departTimeNext();
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Cannot create PreSecurity with no passengers.");
		}
		PreSecurity ticketingLine = new PreSecurity(passengers, r);
		while(ticketingLine.hasNext()) {
			ticketingLine.removeNext();
			count++;
		}
		assertEquals(passengers, count);
	}
	/**
	 * Tests method that gets the departure time of the next passenger in ticketing
	 */
	@Test
	public void testDepartTimeNext() {
		Reporter r = new Log();
		int passengers = 1;
		PreSecurity emptyLine = new PreSecurity(1, r);
		emptyLine.removeNext();
		assertEquals(emptyLine.departTimeNext(), Integer.MAX_VALUE);
		PreSecurity ticketingLine = new PreSecurity(passengers, r);
		Passenger p = ticketingLine.nextToGo();
		assertEquals(ticketingLine.departTimeNext(), p.getArrivalTime());
		
	}
	/**
	 * Tests method that returns the next passenger in ticketing
	 */
	@Test
	public void testNextToGo() {
		Reporter r = new Log();
		int passengers = 1;
		Passenger empty = null;
		PreSecurity emptyLine = new PreSecurity(1, r);
		emptyLine.removeNext();
		assertEquals(emptyLine.nextToGo(), empty);
		PreSecurity ticketingLine = new PreSecurity(passengers, r);
		assertNotNull(ticketingLine.nextToGo());
	}
	/**
	 * Tests method that determines if there are still passengers in the ticketing line
	 */
	@Test
	public void testHasNext() {
		Reporter r = new Log();
		int passengers = 1;
		PreSecurity emptyLine = new PreSecurity(1, r);
		emptyLine.removeNext();
		assertFalse(emptyLine.hasNext());
		PreSecurity ticketingLine = new PreSecurity(passengers, r);
		assertTrue(ticketingLine.hasNext());
	}
	/**
	 * Tests method that removes the next passenger
	 */
	@Test
	public void testRemoveNext() {
		Reporter r = new Log();
		int passengers = 1;
		PreSecurity emptyLine = new PreSecurity(1, r);
		emptyLine.removeNext()
;		try {
			emptyLine.removeNext();
		} catch (NoSuchElementException e) {
			assertEquals(e.getMessage(), "No passengers to remove");
		}
		PreSecurity ticketingLine = new PreSecurity(passengers, r);
		try {
			ticketingLine.removeNext();
			assertFalse(ticketingLine.hasNext());
		} catch (NoSuchElementException e) {
			assertEquals(e.getMessage(), "No passengers to remove");
		}
		
	}

}
