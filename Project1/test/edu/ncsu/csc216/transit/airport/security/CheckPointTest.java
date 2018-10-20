package edu.ncsu.csc216.transit.airport.security;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import edu.ncsu.csc216.transit.airport.travelers.OrdinaryPassenger;
import edu.ncsu.csc216.transit.airport.travelers.Passenger;
import edu.ncsu.csc216.transit.simulation_utils.Log;
import edu.ncsu.csc216.transit.simulation_utils.Reporter;

public class CheckPointTest {

	@Test
	public void testCheckPoint() {
		CheckPoint c = new CheckPoint();
		assertEquals(c.size(), 0);
	}

	@Test
	public void testSize() {
		CheckPoint c = new CheckPoint();
		assertEquals(c.size(), 0);
		Reporter r = new Log();
		Passenger p = new OrdinaryPassenger(0,0,r);
		c.addToLine(p);
		assertEquals(c.size(),1);
	}

	@Test
	public void testRemoveFromLine() {
		CheckPoint c = new CheckPoint();
		try {
			c.removeFromLine();
		} catch(NoSuchElementException e) {
			assertEquals(e.getMessage(), "No passengers to remove");
		}
		Reporter r = new Log();
		Passenger p = new OrdinaryPassenger(0,0,r);
		c.addToLine(p);
		try {
			c.removeFromLine();
			assertEquals(c.size(), 0);
		} catch(NoSuchElementException e) {
			assertEquals(e.getMessage(), "No passengers to remove");
		}
		
		
	}

	@Test
	public void testHasNext() {
		CheckPoint c = new CheckPoint();
		assertFalse(c.hasNext());
		Reporter r = new Log();
		Passenger p = new OrdinaryPassenger(0,0,r);
		c.addToLine(p);
		assertTrue(c.hasNext());
		
	}

	@Test
	public void testDepartTimeNext() {
		CheckPoint c = new CheckPoint();
		assertEquals(c.departTimeNext(), Integer.MAX_VALUE);
		Reporter r = new Log();
		Passenger p = new OrdinaryPassenger(5,10,r);
		c.addToLine(p);
		assertEquals(c.departTimeNext(), 15);
	}

	@Test
	public void testNextToGo() {
		CheckPoint c = new CheckPoint();
		assertEquals(c.nextToGo(), null);
		Reporter r = new Log();
		Passenger p = new OrdinaryPassenger(5,10,r);
		c.addToLine(p);
		assertEquals(c.nextToGo(), p);
	}

	@Test
	public void testAddToLine() {
		CheckPoint c = new CheckPoint();
		assertFalse(c.hasNext());
		Reporter r = new Log();
		Passenger p = new OrdinaryPassenger(5,10,r);
		c.addToLine(p);
		assertTrue(c.hasNext());
		assertEquals(p.getWaitTime(), 0);
		Reporter t = new Log();
		Passenger q = new OrdinaryPassenger(10,15,t);
		c.addToLine(q);
		assertEquals(q.getWaitTime(), 15 - q.getArrivalTime());
	}

}
