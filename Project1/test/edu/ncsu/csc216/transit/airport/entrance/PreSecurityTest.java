package edu.ncsu.csc216.transit.airport.entrance;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import edu.ncsu.csc216.transit.airport.travelers.Passenger;
import edu.ncsu.csc216.transit.simulation_utils.Log;
import edu.ncsu.csc216.transit.simulation_utils.Reporter;

public class PreSecurityTest {

	@Test
	public void testPreSecurity() {
		Reporter r = new Log();
		int passengers = 10;
		int count = 0;
		PreSecurity ticketingLine = new PreSecurity(passengers, r);
		while(ticketingLine.hasNext()) {
			ticketingLine.removeNext();
			count++;
		}
		assertEquals(passengers, count);
	}

	@Test
	public void testDepartTimeNext() {
		Reporter r = new Log();
		int passengers = 1;
		PreSecurity emptyLine = new PreSecurity(0, r);
		assertEquals(emptyLine.departTimeNext(), Integer.MAX_VALUE);
		PreSecurity ticketingLine = new PreSecurity(passengers, r);
		Passenger p = ticketingLine.nextToGo();
		assertEquals(ticketingLine.departTimeNext(), p.getArrivalTime());
		
	}

	@Test
	public void testNextToGo() {
		Reporter r = new Log();
		int passengers = 1;
		Passenger empty = null;
		PreSecurity emptyLine = new PreSecurity(0, r);
		assertEquals(emptyLine.nextToGo(), empty);
		PreSecurity ticketingLine = new PreSecurity(passengers, r);
		assertNotNull(ticketingLine.nextToGo());
	}

	@Test
	public void testHasNext() {
		Reporter r = new Log();
		int passengers = 1;
		PreSecurity emptyLine = new PreSecurity(0, r);
		assertFalse(emptyLine.hasNext());
		PreSecurity ticketingLine = new PreSecurity(passengers, r);
		assertTrue(ticketingLine.hasNext());
	}

	@Test
	public void testRemoveNext() {
		Reporter r = new Log();
		int passengers = 1;
		PreSecurity emptyLine = new PreSecurity(0, r);
		try {
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
