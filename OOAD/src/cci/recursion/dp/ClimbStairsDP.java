/**
 * 
 */
package cci.recursion.dp;

import java.util.Scanner;

/**
 * @author Aparna Ganesh
 * dynamic prog approach to calc num of ways to climb stairs
 * the tweek is to cache results in an array before recursive calls
 */
public class ClimbStairsDP {

	public static int climbStairsDP(int i,int[] cache) {
		
		if(i<0) {
			return 0;
		}
		else if(i==0) {
			return 1;
		}
		else if (cache[i] > -1) { //returning the cached result,arr is initiazed to 0
			return cache[i];
		}
		else { //storing result in cache
			cache[i] = climbStairsDP(i-1,cache) + climbStairsDP(i-2,cache)+climbStairsDP(i-3,cache);
		}
		return cache[i];
		
	}
	
	public static void main(String args[]) {
		Scanner scanner =  new Scanner(System.in);
		System.out.println("enter the num of stairs ");
		int numOfStarirs = scanner.nextInt();
		int cache[] = new int[numOfStarirs+1];
		System.out.println("Num of ways to climb "+ClimbStairsDP.climbStairsDP(numOfStarirs,cache));
	}
	
}
