package edu.ncsu.csc216.transit.airport.security;

import static org.junit.Assert.*;

import org.junit.Test;


import edu.ncsu.csc216.transit.airport.travelers.FastTrackPassenger;
import edu.ncsu.csc216.transit.airport.travelers.OrdinaryPassenger;
import edu.ncsu.csc216.transit.airport.travelers.Passenger;
import edu.ncsu.csc216.transit.simulation_utils.Log;
import edu.ncsu.csc216.transit.simulation_utils.Reporter;
/**
 * Tests the functionality of SecurityArea objects
 * @author Max Richgruber
 *
 */
public class SecurityAreaTest {
	/**
	 * Tests the SecurityArea constructor
	 */
	@Test
	public void testSecurityArea() {
		try {
			SecurityArea a = new SecurityArea(2);
			a.departTimeNext();
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Number of checkpoints must be at least 3 and at most 17.");
		}
		try {
			SecurityArea b = new SecurityArea(18);
			b.departTimeNext();
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Number of checkpoints must be at least 3 and at most 17.");
		}
		SecurityArea c = new SecurityArea(3);
		assertEquals(c.shortestFastTrackLine(), 0);
		assertEquals(c.shortestRegularLine(), 1);
		assertEquals(c.shortestTSAPreLine(), 2);
	}
	/**
	 * Tests the method that adds a passenger to a specified line
	 */
	@Test
	public void testAddToLine() {
		SecurityArea a = new SecurityArea(3);
		assertNull(a.nextToGo());
		Reporter r = new Log();
		Passenger p = new FastTrackPassenger(10, 10, r);
		a.addToLine(0, p);
		assertEquals(a.nextToGo(), p);
	}
	/**
	 * Tests the method that returns the index of the shortest regular line
	 */
	@Test
	public void testShortestRegularLine() {
		SecurityArea a = new SecurityArea(9);
		assertEquals(a.shortestRegularLine(), 3);
		Reporter r = new Log();
		Passenger p = new OrdinaryPassenger(10, 10, r);
		a.addToLine(3, p);
		assertEquals(a.shortestRegularLine(), 4);
		Passenger q = new OrdinaryPassenger(10, 10, r);
		a.addToLine(4, q);
		assertEquals(a.shortestRegularLine(), 5);
		Passenger s = new OrdinaryPassenger(10, 10, r);
		a.addToLine(5, s);
		assertEquals(a.shortestRegularLine(), 6);
		Passenger t = new OrdinaryPassenger(10, 10, r);
		a.addToLine(6, t);
		assertEquals(a.shortestRegularLine(), 7);
		Passenger u = new OrdinaryPassenger(10, 10, r);
		a.addToLine(7, u);
		assertEquals(a.shortestRegularLine(), 3);
	}
	/**
	 * Tests the method that returns the index of the shortest fast track line
	 */
	@Test
	public void testShortestFastTrackLine() {
		SecurityArea a = new SecurityArea(9);
		assertEquals(a.shortestFastTrackLine(), 0);
		Reporter r = new Log();
		Passenger p = new FastTrackPassenger(10, 10, r);
		a.addToLine(0, p);
		assertEquals(a.lengthOfLine(0), 1);
		assertEquals(a.shortestFastTrackLine(), 1);
		Passenger q = new FastTrackPassenger(10, 10, r);
		a.addToLine(1, q);
		assertEquals(a.lengthOfLine(1), 1);
		assertEquals(a.lengthOfLine(2), 0);
		assertEquals(a.shortestFastTrackLine(), 2);
		Passenger t = new FastTrackPassenger(10, 10, r);
		a.addToLine(2, t);
		assertEquals(a.shortestFastTrackLine(), 3);
		Passenger u = new FastTrackPassenger(10, 10, r);
		a.addToLine(3, u);
		assertEquals(a.shortestFastTrackLine(), 4);
		Passenger v = new FastTrackPassenger(10, 10, r);
		a.addToLine(4, v);
		assertEquals(a.shortestFastTrackLine(), 5);
		Passenger w = new FastTrackPassenger(10, 10, r);
		a.addToLine(5, w);
		assertEquals(a.shortestFastTrackLine(), 6);
		Passenger x = new FastTrackPassenger(10, 10, r);
		a.addToLine(6, x);
		assertEquals(a.shortestFastTrackLine(), 7);
		Passenger y = new FastTrackPassenger(10, 10, r);
		a.addToLine(7, y);
		assertEquals(a.shortestFastTrackLine(), 0);
		Passenger z = new FastTrackPassenger(10, 10, r);
		a.addToLine(0, z);
		assertEquals(a.shortestFastTrackLine(), 1);
		
	}
	/**
	 * Tests the method that returns the index of the shortest TSA pre-check line
	 */
	@Test
	public void testShortestTSAPreLine() {
		SecurityArea a = new SecurityArea(3);
		assertEquals(a.shortestTSAPreLine(), 2);
		SecurityArea b = new SecurityArea(17);
		assertEquals(b.shortestTSAPreLine(), 16);
		SecurityArea c = new SecurityArea(10);
		assertEquals(c.shortestTSAPreLine(), 9);
		SecurityArea d = new SecurityArea(7);
		assertEquals(d.shortestTSAPreLine(), 6);
	}
	/**
	 * Tests the method that returns the length of a checkpoint line
	 */
	@Test
	public void testLengthOfLine() {
		SecurityArea a  = new SecurityArea(3);
		assertEquals(a.lengthOfLine(0), 0);
		Reporter r = new Log();
		Passenger p = new FastTrackPassenger(10, 10, r);
		a.addToLine(0, p);
		assertEquals(a.lengthOfLine(0), 1);
	}
	/**
	 * Tests the method that returns the earliest depart time of any checkpoint
	 */
	@Test
	public void testDepartTimeNext() {
		Reporter r = new Log();
		SecurityArea a = new SecurityArea(3);
		Passenger p = new OrdinaryPassenger(10, 10, r);
		assertEquals(a.departTimeNext(), Integer.MAX_VALUE);
		a.addToLine(0, p);
		assertEquals(a.departTimeNext(), p.getArrivalTime() + p.getProcessTime() + p.getWaitTime() );
		
	}
	/**
	 * Tests the method that returns the next passenger to leave the security area
	 */
	@Test
	public void testNextToGo() {
		Reporter r = new Log();
		SecurityArea a = new SecurityArea(3);
		Passenger p = new OrdinaryPassenger(10, 10, r);
		a.addToLine(0, p);
		assertEquals(a.nextToGo(), p);
	}
	/**
	 * Tests the method that removes the next passenger to go from the security area
	 */
	@Test
	public void testRemoveNext() {
		Reporter r = new Log();
		SecurityArea a = new SecurityArea(3);
		Passenger p = new OrdinaryPassenger(10, 10, r);
		a.addToLine(0, p);
		a.removeNext();
		assertEquals(a.nextToGo(), null);
	}

}
