package edu.ncsu.csc216.transit.airport.travelers;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import edu.ncsu.csc216.transit.airport.TransitGroup;
import edu.ncsu.csc216.transit.airport.security.SecurityArea;
import edu.ncsu.csc216.transit.simulation_utils.Log;
import edu.ncsu.csc216.transit.simulation_utils.Reporter;

public class OrdinaryPassengerTest {

	@Test
	public void testGetInLine() {
		Reporter r = new Log();
		TransitGroup t = new SecurityArea(3);
		OrdinaryPassenger o = new OrdinaryPassenger(10,10, r);
		o.getInLine(t);
		assertEquals(o, t.nextToGo());
	}

	@Test
	public void testGetColor() {
		Reporter r = new Log();
		OrdinaryPassenger o = new OrdinaryPassenger(10,10,r);
		Color light = new Color(255,153,153);
		assertEquals(light, o.getColor());
		OrdinaryPassenger p = new OrdinaryPassenger(10,200,r);
		Color dark = new Color(255,0,0);
		assertEquals(dark, p.getColor());
	}

	@Test
	public void testOrdinaryPassenger() {
		Reporter r = new Log();
		OrdinaryPassenger o = new OrdinaryPassenger(10,10,r);
		assertEquals(o.getArrivalTime(), 10);
		assertEquals(o.getProcessTime(), 10);
	}

}
