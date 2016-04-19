/**
 * 
 */
package cci.recursion.dp;

/**
 * @author Aparna Ganesh
 *Naive approach to count number of ways to climb 'n' stairs
 *Run time exponential- O(3^N)
 */
public class ClimbStairsR {

	public static int countWays(int i) {
		if(i <0) {
			return 0;
		}
		else if(i==0) {
			return 1;
		}
		else {
			return countWays(i-1) + countWays(i-2) + countWays(i-3);
		}
	}
	
	public static void main(String args[]) {
		int numOfStairs = 6;
		int numOfWays = ClimbStairsR.countWays(numOfStairs);
		System.out.println("Number of ways to climb "+numOfStairs+" is "+numOfWays);
	}
}
