package edu.ncsu.csc216.transit.airport.security;




import edu.ncsu.csc216.transit.airport.TransitGroup;
import edu.ncsu.csc216.transit.airport.travelers.Passenger;
/**
 * Class that describes the pool of security checkpoints
 * @author Max Richgruber
 *
 */
public class SecurityArea implements TransitGroup {
	/** Collection of all security checkpoints */
	private CheckPoint[] check;
	/** Maximum number of checkpoints */
	private static final int MAX_CHECKPOINTS = 17;
	/** Minimum number of checkpoints */
	private static final int MIN_CHECKPOINTS = 3;
	/** Error with checkpoints */
	private static final String ERROR_CHECKPOINTS = "Number of checkpoints must be at least 3 and at most 17.";
	/** Error with a checkpoint index */
	private static final String ERROR_INDEX = "Index out of range for this security area";
	/** Largest index of any Fast Track Checkpoint */
	private int largestFastIndex;
	/** The index of the Trusted Traveler Checkpoint */
	private int tsaPreIndex;
	/**
	 * Constructor of the SecurityArea object
	 * @param numCheckpoints number of checkpoints
	 */
	public SecurityArea(int numCheckpoints){
		if(numGatesOK(numCheckpoints)) {
			this.check = new CheckPoint[numCheckpoints];
			float checkFloat = numCheckpoints;
	        float temp = checkFloat / 3;
	        int numFast = 0;
	        if(temp > numCheckpoints / 3){
	            numFast = (numCheckpoints / 3) + 1;
	        } else{
	            numFast = numCheckpoints / 3;
	        }
			for(int i = 0; i < check.length; i++) {
				check[i] = new CheckPoint();
				if(i == numFast - 1) {
					this.largestFastIndex = i;
				}
				if(i == check.length - 1) {
					this.tsaPreIndex = i;
				}
			}
		} else {
			throw new IllegalArgumentException(ERROR_CHECKPOINTS);
		}
	}
	/**
	 * Determines if the number of checkpoints is valid
	 * @param checkpoints number of checkpoints
	 * @return Whether the created number of checkpoints is valid
	 */
	private boolean numGatesOK(int checkpoints) {
		if(checkpoints < MIN_CHECKPOINTS || checkpoints > MAX_CHECKPOINTS) {
			return false;
		}
		return true;
	}
	/**
	 * Add a passenger to a checkpoint line
	 * @param i index of the line to add to
	 * @param p the passenger to be added
	 */
	public void addToLine(int i, Passenger p) {
		if(i < 0 || i > tsaPreIndex) {
			throw new IllegalArgumentException(ERROR_INDEX);
		}
		check[i].addToLine(p);
	}
	/**
	 * Gets the shortest regular line
	 * @return index of the shortest regular line
	 */
	public int shortestRegularLine() {
		int shortest = shortestLineInRange(largestFastIndex + 1, tsaPreIndex - 1);
		return shortest;
	}
	/**
	 * Gets the shortest fast track line
	 * @return index of the shortest fast track line
	 */
	public int shortestFastTrackLine() {
		int shortest = shortestLineInRange(0, tsaPreIndex - 1);
		return shortest;
	}
	/**
	 * Gets the shortest trusted traveler line
	 * @return index of the shortest trusted traveler line
	 */
	public int shortestTSAPreLine() {
		return tsaPreIndex;
	}
	/**
	 * Gets the length of the line
	 * @param i index of the line to be checked
	 * @return length of the specified line
	 */
	public int lengthOfLine(int i) {
		if(i < 0 || i > tsaPreIndex) {
			throw new IllegalArgumentException(ERROR_INDEX);
		}
		CheckPoint c = check[i];
		return c.size();
	}
	/**
	 * Gets the depart time of the next passenger
	 * @return the next depart time
	 */
	public int departTimeNext() {
		int nextLine = lineWithNextToClear();
		return check[nextLine].departTimeNext();
	}
	/**
	 * Gets the next passenger to go
	 * @return the next passenger
	 */
	public Passenger nextToGo() {
		int nextLine = lineWithNextToClear();
		return check[nextLine].nextToGo();
	}
	/**
	 * Removes the passenger that is up next
	 * @return the passenger that was removed
	 */
	public Passenger removeNext() {
		int nextLine = lineWithNextToClear();
		return check[nextLine].removeFromLine();
	}
	/**
	 * Gets the shortest line in a range 
	 * @param i index to start the range
	 * @param j index to end the range
	 * @return shortest line in the provided range
	 */
	private int shortestLineInRange(int start, int end) {
		int shortest = Integer.MAX_VALUE;
		int shortIndex = start;
		for(int i = start; i <= end; i++ ) {
			if(lengthOfLine(i) < shortest) {
				shortest = lengthOfLine(i);
				shortIndex = i;
			} 
		}
		return shortIndex;
	}
	/**
	 * Gets the line that is going to clear a passenger next
	 * @return index of the next line to clear a passenger
	 */
	private int lineWithNextToClear() {
		int next = 0;
		int temp = Integer.MAX_VALUE;
		for(int i = 0; i < check.length; i++) {
			CheckPoint c = check[i];
			if(c.departTimeNext() < temp) {
				temp = c.departTimeNext();
				next = i;
			}	
		}
		return next;
	}
	
	
	
}
