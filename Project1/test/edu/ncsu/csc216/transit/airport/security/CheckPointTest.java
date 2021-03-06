package edu.ncsu.csc216.transit.airport.security;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import edu.ncsu.csc216.transit.airport.travelers.OrdinaryPassenger;
import edu.ncsu.csc216.transit.airport.travelers.Passenger;
import edu.ncsu.csc216.transit.simulation_utils.Log;
import edu.ncsu.csc216.transit.simulation_utils.Reporter;
/**
 * Tests the functionality of CheckPoint objects
 * @author Max Richgruber
 *
 */
public class CheckPointTest {
	/**
	 * Tests CheckPoint constructor
	 */
	@Test
	public void testCheckPoint() {
		CheckPoint c = new CheckPoint();
		assertEquals(c.size(), 0);
	}
	/**
	 * Tests the method that returns checkpoint size
	 */
	@Test
	public void testSize() {
		CheckPoint c = new CheckPoint();
		assertEquals(c.size(), 0);
		Reporter r = new Log();
		Passenger p = new OrdinaryPassenger(0, 20, r);
		c.addToLine(p);
		assertEquals(c.size(), 1);
	}
	/**
	 * Tests the method that removes passengers from a checkpoint line
	 */
	@Test
	public void testRemoveFromLine() {
		CheckPoint c = new CheckPoint();
		try {
			c.removeFromLine();
		} catch(NoSuchElementException e) {
			assertEquals(e.getMessage(), "No passengers to remove");
		}
		Reporter r = new Log();
		Passenger p = new OrdinaryPassenger(0, 20, r);
		c.addToLine(p);
		try {
			c.removeFromLine();
			assertEquals(c.size(), 0);
		} catch(NoSuchElementException e) {
			assertEquals(e.getMessage(), "No passengers to remove");
		}
		
		
	}
	/**
	 * Tests the method that checks if the checkpoint has another passenger in the line
	 */
	@Test
	public void testHasNext() {
		CheckPoint c = new CheckPoint();
		assertFalse(c.hasNext());
		Reporter r = new Log();
		Passenger p = new OrdinaryPassenger(0, 20, r);
		c.addToLine(p);
		assertTrue(c.hasNext());
		
	}
	/**
	 * Tests the method that gets the departure time of the next passenger at a checkpoint
	 */
	@Test
	public void testDepartTimeNext() {
		CheckPoint c = new CheckPoint();
		assertEquals(c.departTimeNext(), Integer.MAX_VALUE);
		Reporter r = new Log();
		Passenger p = new OrdinaryPassenger(5, 20, r);
		c.addToLine(p);
		assertEquals(c.departTimeNext(), 25);
	}
	/**
	 * Tests the method that returns the next passenger to go from a checkpoint
	 */
	@Test
	public void testNextToGo() {
		CheckPoint c = new CheckPoint();
		assertEquals(c.nextToGo(), null);
		Reporter r = new Log();
		Passenger p = new OrdinaryPassenger(5, 20, r);
		c.addToLine(p);
		assertEquals(c.nextToGo(), p);
	}
	/**
	 * Tests the method that adds a passenger to a checkpoint line
	 */
	@Test
	public void testAddToLine() {
		CheckPoint c = new CheckPoint();
		assertFalse(c.hasNext());
		Reporter r = new Log();
		Passenger p = new OrdinaryPassenger(5, 20, r);
		c.addToLine(p);
		assertTrue(c.hasNext());
		assertEquals(p.getWaitTime(), 0);
		Reporter t = new Log();
		Passenger q = new OrdinaryPassenger(5, 20, t);
		c.addToLine(q);
		assertEquals(q.getWaitTime(), 25 - q.getArrivalTime());
		
	
	}
	
	

}
