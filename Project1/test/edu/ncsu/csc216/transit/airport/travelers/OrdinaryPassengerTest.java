package edu.ncsu.csc216.transit.airport.travelers;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import edu.ncsu.csc216.transit.airport.TransitGroup;
import edu.ncsu.csc216.transit.airport.security.SecurityArea;
import edu.ncsu.csc216.transit.simulation_utils.Log;
import edu.ncsu.csc216.transit.simulation_utils.Reporter;
/**
 * Tests the functionality of OrdinaryPassenger objects
 * @author Max Richgruber
 *
 */
public class OrdinaryPassengerTest {
	/**
	 * Tests the method that moves the passenger to a line
	 */
	@Test
	public void testGetInLine() {
		Reporter r = new Log();
		TransitGroup t = new SecurityArea(3);
		OrdinaryPassenger o = new OrdinaryPassenger(10, 20, r);
		o.getInLine(t);
		assertEquals(o, t.nextToGo());
	}
	/**
	 * Tests the method that returns the passenger's color
	 */
	@Test
	public void testGetColor() {
		Reporter r = new Log();
		OrdinaryPassenger o = new OrdinaryPassenger(10, 20, r);
		Color light = new Color(255, 153, 153);
		assertEquals(light, o.getColor());
		OrdinaryPassenger p = new OrdinaryPassenger(10, 200, r);
		Color dark = new Color(255, 0, 0);
		assertEquals(dark, p.getColor());
	}
	/**
	 * Tests OrdinaryPassenger constructor
	 */
	@Test
	public void testOrdinaryPassenger() {
		Reporter r = new Log();
		OrdinaryPassenger o = new OrdinaryPassenger(10, 20, r);
		assertEquals(o.getArrivalTime(), 10);
		assertEquals(o.getProcessTime(), 20);
	}

}
