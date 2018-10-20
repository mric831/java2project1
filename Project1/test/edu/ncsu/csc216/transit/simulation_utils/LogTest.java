package edu.ncsu.csc216.transit.simulation_utils;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.transit.airport.travelers.OrdinaryPassenger;
import edu.ncsu.csc216.transit.airport.travelers.Passenger;

public class LogTest {

	@Test
	public void testLog() {
		Log l = new Log();
		assertEquals(l.getNumCompleted(), 0);

	}

	@Test
	public void testGetNumCompleted() {
		Log l = new Log();
		assertEquals(l.getNumCompleted(), 0);
		Passenger p = new OrdinaryPassenger(10,10, l);
		l.logData(p);
		assertEquals(l.getNumCompleted(), 1);
	}

	@Test
	public void testLogData() {
		Log l = new Log();
		Passenger p = new OrdinaryPassenger(10,10, l);
		p.setWaitTime(15);
		l.logData(p);
		assertEquals(l.getNumCompleted(), 1);
		double process = 10/1;
		double wait = 15/1;
		assertEquals(l.averageWaitTime(), wait, 0);
		assertEquals(l.averageProcessTime(),process, 0);
	}

	@Test
	public void testAverageWaitTime() {
		Log l = new Log();
		Passenger p = new OrdinaryPassenger(10,10, l);
		try {
			l.logData(p);
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Invalid operation");
		}
		Log ll = new Log();
		p.setWaitTime(15);
		ll.logData(p);
		double wait = 15/1;
		assertEquals(ll.averageWaitTime(), wait, 0);

	}

	@Test
	public void testAverageProcessTime() {
		Log l = new Log();
		Passenger p = new OrdinaryPassenger(10,10, l);
		try {
			l.logData(p);
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Invalid operation");
		}
		Log ll = new Log();
		ll.logData(p);
		double process = 10/1;
		assertEquals(ll.averageProcessTime(), process, 0);

	}

}
