package edu.ncsu.csc216.transit.simulation_utils;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class SimulatorTest {

	@Test
	public void testSimulator() {
		int check = 3;
		int passengers = 0;
		int trusted = 10;
		int ordinary = 30;
		int fast = 60;
		try {
			Simulator s = new Simulator(check, passengers, trusted, fast, ordinary);
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "There must be at least one passenger.");
		}
		passengers = 1;
		fast = 50;
		try {
			Simulator s = new Simulator(check, passengers, trusted, fast, ordinary);
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Percents must sum to 100.");
		}
	}

	@Test
	public void testGetReporter() {
		Simulator s = new Simulator(3, 1, 10, 30, 60);
		Log l = (Log) s.getReporter();
		assertEquals(l.getNumCompleted(), 0);
		s.step();
		s.step();
		assertEquals(l.getNumCompleted(), 1);
		
	}

	@Test
	public void testStep() {
		Simulator s = new Simulator(3, 1, 0, 0, 100);	
		assertFalse(s.passengerClearedSecurity());
		s.step();
		assertFalse(s.passengerClearedSecurity());
		s.step();
		assertTrue(s.passengerClearedSecurity());
		
	}

	@Test
	public void testMoreSteps() {
		Simulator s = new Simulator(3, 1, 10, 30, 60);
		assertTrue(s.moreSteps());
		s.step();//move to checkpoint
		s.step();//move out of checkpoint
		assertFalse(s.moreSteps());
		
	}

	@Test
	public void testGetCurrentIndex() {
		Simulator s = new Simulator(3, 1, 10, 30, 60);
		assertEquals(s.getCurrentIndex(), -1);
		s.step();
		assertEquals(s.getCurrentIndex(), 1);
		s.step();
		assertEquals(s.getCurrentIndex(), -1);
	}

	@Test
	public void testGetCurrentPassengerColor() {
		Simulator s = new Simulator(3, 1, 0, 0, 100);
		assertEquals(s.getCurrentPassengerColor(), null);
		s.step();
		assertEquals(s.getCurrentPassengerColor(), Color.RED);
		

	}

	@Test
	public void testPassengerClearedSecurity() {
		Simulator s = new Simulator(3, 1, 10, 30, 60);
		assertFalse(s.passengerClearedSecurity());
		s.step();
		assertFalse(s.passengerClearedSecurity());
		s.step();
		assertTrue(s.passengerClearedSecurity());
		
	}

}
