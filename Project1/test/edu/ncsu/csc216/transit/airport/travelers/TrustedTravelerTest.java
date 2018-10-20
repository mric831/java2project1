package edu.ncsu.csc216.transit.airport.travelers;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import edu.ncsu.csc216.transit.airport.TransitGroup;
import edu.ncsu.csc216.transit.airport.security.SecurityArea;
import edu.ncsu.csc216.transit.simulation_utils.Log;
import edu.ncsu.csc216.transit.simulation_utils.Reporter;

public class TrustedTravelerTest {

	@Test
	public void testGetInLine() {
		Reporter r = new Log();
		TransitGroup t = new SecurityArea(3);
		TrustedTraveler f = new TrustedTraveler(10,10, r);
		f.getInLine(t);
		assertEquals(f, t.nextToGo());
	}

	@Test
	public void testGetColor() {
		Reporter r = new Log();
		TrustedTraveler f = new TrustedTraveler(10,10,r);
		Color light = new Color(153,255,153);
		assertEquals(light, f.getColor());
		TrustedTraveler e = new TrustedTraveler(10,200,r);
		Color dark = new Color(0,255,0);
		assertEquals(dark, e.getColor());
	}

	@Test
	public void testTrustedTraveler() {
		Reporter r = new Log();
		TrustedTraveler f = new TrustedTraveler(10,10,r);
		assertEquals(f.getArrivalTime(), 10);
		assertEquals(f.getProcessTime(), 10);
	}

}
