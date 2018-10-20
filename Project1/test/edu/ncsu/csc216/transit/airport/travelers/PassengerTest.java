package edu.ncsu.csc216.transit.airport.travelers;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import edu.ncsu.csc216.transit.airport.TransitGroup;
import edu.ncsu.csc216.transit.airport.security.SecurityArea;
import edu.ncsu.csc216.transit.simulation_utils.Log;
import edu.ncsu.csc216.transit.simulation_utils.Reporter;

public class PassengerTest {

	@Test
	public void testPassenger() {
		Reporter r = new Log();
		Passenger p = new OrdinaryPassenger(10, 15, r);
		assertEquals(p.getArrivalTime(), 10);
		assertEquals(p.getProcessTime(), 15);
		
	}

	@Test
	public void testGetArrivalTime() {
		Reporter r = new Log();
		Passenger p = new OrdinaryPassenger(10, 15, r);
		assertEquals(p.getArrivalTime(), 10);
	}

	@Test
	public void testGetWaitTime() {
		Reporter r = new Log();
		Passenger p = new OrdinaryPassenger(10, 15, r);
		assertEquals(p.getWaitTime(), 0);
		p.setWaitTime(20);
		assertEquals(p.getWaitTime(), 20);
	}

	@Test
	public void testSetWaitTime() {
		Reporter r = new Log();
		Passenger p = new OrdinaryPassenger(10, 15, r);
		assertEquals(p.getWaitTime(), 0);
		p.setWaitTime(20);
		assertEquals(p.getWaitTime(), 20);
		try {
			p.setWaitTime(-5);
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Invalid Wait Time");
		}
	}

	@Test
	public void testGetProcessTime() {
		Reporter r = new Log();
		Passenger p = new OrdinaryPassenger(10, 15, r);
		assertEquals(p.getProcessTime(), 15);
	}

	@Test
	public void testGetLineIndex() {
		Reporter r = new Log();
		Passenger p = new OrdinaryPassenger(10, 15, r);
		assertEquals(p.getLineIndex(), 0);
		
	}

	@Test
	public void testIsWaitingInSecurityLine() {
		Reporter r = new Log();
		Passenger p = new OrdinaryPassenger(10, 15, r);
		assertFalse(p.isWaitingInSecurityLine());
		p.setLineIndex(1);
		assertTrue(p.isWaitingInSecurityLine());
	}

	@Test
	public void testClearSecurity() {
		Reporter r = new Log();
		Passenger p = new OrdinaryPassenger(10, 15, r);
		p.setLineIndex(1);
		p.clearSecurity();
		assertFalse(p.isWaitingInSecurityLine());
		
	}

	@Test
	public void testSetLineIndex() {
		Reporter r = new Log();
		Passenger p = new OrdinaryPassenger(10, 15, r);
		p.setLineIndex(1);
		assertEquals(p.getLineIndex(), 1);
		assertTrue(p.isWaitingInSecurityLine());
	}

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

}
