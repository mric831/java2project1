package edu.ncsu.csc216.transit.airport.travelers;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import edu.ncsu.csc216.transit.airport.TransitGroup;
import edu.ncsu.csc216.transit.airport.security.SecurityArea;
import edu.ncsu.csc216.transit.simulation_utils.Log;
import edu.ncsu.csc216.transit.simulation_utils.Reporter;
/**
 * Tests the functionality of FastTrackPassenger objects
 * @author Max Richgruber
 *
 */
public class FastTrackPassengerTest {
	/**
	 * Tests the method that moves the passenger to a line
	 */
	@Test
	public void testGetInLine() {
		Reporter r = new Log();
		TransitGroup t = new SecurityArea(3);
		FastTrackPassenger f = new FastTrackPassenger(10, 20, r);
		f.getInLine(t);
		assertEquals(f, t.nextToGo());
	}
	/**
	 * Tests the method that returns the passenger's color
	 */
	@Test
	public void testGetColor() {
		Reporter r = new Log();
		FastTrackPassenger f = new FastTrackPassenger(10, 20, r);
		Color light = new Color(153, 153, 255);
		assertEquals(light, f.getColor());
		FastTrackPassenger e = new FastTrackPassenger(10, 200, r);
		Color dark = new Color(0, 0, 255);
		assertEquals(dark, e.getColor());
	}
	/**
	 * Tests FastTrackPassenger constructor
	 */
	@Test
	public void testFastTrackPassenger() {
		Reporter r = new Log();
		FastTrackPassenger f = new FastTrackPassenger(10, 20, r);
		assertEquals(f.getArrivalTime(), 10);
		assertEquals(f.getProcessTime(), 20);
	}

}
