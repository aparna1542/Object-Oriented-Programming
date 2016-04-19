/**
 * 
 */
package cci.arrays.strings;

/**
 * @author Aparna Ganesh Determine from which index if the car starts,it can
 *         complete a full circle,without fuel exhaustion (quantity of gas at
 *         every station and cost to travel from station i to i+1 is also given)
 */
public class GasStation {

	// this method returns the index at which if a car starts can complete a
	// circuit
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int start = 0; // remaining fuel at every gas station
		int currentReamining = 0; // tracks the previous value so far
		int total = 0; // after going over all the gas stations
		for (int i = 0; i < gas.length; i++) {
			int remaining = gas[i] - cost[i];
			if (currentReamining >= 0) { // continue, 
				currentReamining += remaining;
			} else { //if curr remaing is -ve,there is no path from prev index
				currentReamining = remaining;
				start = i;
			}
			total = total + remaining; //to track whether loop can be done or not
		}
		if (total >= 0) {
			return start; //which index will be ideal for a start 
		} else {
			return -1;
		}

	}
}