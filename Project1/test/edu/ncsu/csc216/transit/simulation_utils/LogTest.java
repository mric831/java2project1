package edu.ncsu.csc216.transit.simulation_utils;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.transit.airport.travelers.OrdinaryPassenger;
import edu.ncsu.csc216.transit.airport.travelers.Passenger;
/**
 * Tests the functionality of log objects
 * @author Max Richgruber
 *
 */
public class LogTest {
	/**
	 * Tests the log constructor
	 */
	@Test
	public void testLog() {
		Log l = new Log();
		assertEquals(l.getNumCompleted(), 0);

	}
	/**
	 * Tests the method that returns the number of logged passengers
	 */
	@Test
	public void testGetNumCompleted() {
		Log l = new Log();
		assertEquals(l.getNumCompleted(), 0);
		Passenger p = new OrdinaryPassenger(10, 20, l);
		l.logData(p);
		assertEquals(l.getNumCompleted(), 1);
	}
	/**
	 * Tests the method that logs passengers when they've cleared security
	 */
	@Test
	public void testLogData() {
		Log l = new Log();
		Passenger p = new OrdinaryPassenger(10, 20, l);
		p.setWaitTime(15);
		l.logData(p);
		assertEquals(l.getNumCompleted(), 1);
		double process = 10 / 60;
		double wait = 15 / 60;
		assertEquals(l.averageWaitTime(), wait, 0);
		assertEquals(l.averageProcessTime(), process, 0);
	}
	/**
	 * Test the method that computes average wait time
	 */
	@Test
	public void testAverageWaitTime() {
		Log l = new Log();
		Passenger p = new OrdinaryPassenger(10, 20, l);
		try {
			l.logData(p);
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Invalid operation");
		}
		Log ll = new Log();
		p.setWaitTime(15);
		ll.logData(p);
		double wait = 15 / 60;
		assertEquals(ll.averageWaitTime(), wait, 0);

	}
	/**
	 * Tests the method that computes average process time
	 */
	@Test
	public void testAverageProcessTime() {
		Log l = new Log();
		Passenger p = new OrdinaryPassenger(10, 20, l);
		try {
			l.logData(p);
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Invalid operation");
		}
		Log ll = new Log();
		ll.logData(p);
		double process = 10 / 60;
		assertEquals(ll.averageProcessTime(), process, 0);

	}

}
