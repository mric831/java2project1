package edu.ncsu.csc216.transit.simulation_utils;

import static org.junit.Assert.*;



import org.junit.Test;

import edu.ncsu.csc216.transit.airport.entrance.Ticketing;
/**
 * Tests the functionality of the simulator class that runs the simulation
 * @author Max Richgruber
 *
 */
public class SimulatorTest {
	/**
	 * Tests simulator constructor
	 */
	@Test
	public void testSimulator() {
		int check = 3;
		int passengers = 0;
		int trusted = 10;
		int ordinary = 30;
		int fast = 60;
		try {
			Simulator s = new Simulator(check, passengers, trusted, fast, ordinary);
			s.moreSteps();
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "There must be at least one passenger.");
		}
		passengers = 1;
		fast = 50;
		try {
			Simulator s = new Simulator(check, passengers, trusted, fast, ordinary);
			s.moreSteps();
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Percents must sum to 100.");
		}
		Ticketing.resetFactory();
	}
	/**
	 * Tests the method that returns the simulation log
	 */
	@Test
	public void testGetReporter() {
		Simulator s = new Simulator(3, 1, 10, 30, 60);
		Log l = (Log) s.getReporter();
		assertEquals(l.getNumCompleted(), 0);
		s.step();
		s.step();
		assertEquals(l.getNumCompleted(), 1);
		
	}
	/**
	 * Tests the method that advances the simulation
	 */
	@Test
	public void testStep() {
		Simulator s = new Simulator(3, 1, 0, 0, 100);	
		assertFalse(s.passengerClearedSecurity());
		s.step();
		assertFalse(s.passengerClearedSecurity());
		s.step();
		assertTrue(s.passengerClearedSecurity());
		assertFalse(s.moreSteps());
		try {
			s.step();
		} catch(IllegalStateException e) {
			assertNotNull(e);
		}
		
	}
	/**
	 * Tests the method that determines if there are more steps in the simulation
	 */
	@Test
	public void testMoreSteps() {
		Simulator s = new Simulator(3, 1, 10, 30, 60);
		assertTrue(s.moreSteps());
		s.step(); //move to checkpoint
		s.step(); //move out of checkpoint
		assertFalse(s.moreSteps());
		
	}
	/**
	 * Tests the method that returns the line of the current passenger
	 */
	@Test
	public void testGetCurrentIndex() {
		Simulator s = new Simulator(3, 1, 10, 30, 60);
		assertEquals(s.getCurrentIndex(), -1);
		s.step();
		assertEquals(s.getCurrentIndex(), 1);
		s.step();

	}
	/**
	 * Tests the method that returns the current passenger's color
	 */
	@Test
	public void testGetCurrentPassengerColor() {
		Simulator s = new Simulator(3, 1, 0, 0, 100);
		assertEquals(s.getCurrentPassengerColor(), null);
		s.step();

		

	}
	/**
	 * Tests the method that determines if the current passenger has cleared security
	 */
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
