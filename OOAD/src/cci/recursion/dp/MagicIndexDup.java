/**
 * 
 */
package cci.recursion.dp;

import java.util.Arrays;

/**
 * @author Aparna Ganesh
 * Given a sorted arr of integers with duplicate elements find magic index
 * find the magic index on both LHS and RHS
 */
public class MagicIndexDup {

	public static int magicIndex(int[] arr,int start,int end) {
		if(start <0 && end >= arr.length && end <start) {
			return -1;
		}
		int midIndex = (start + end) /2;
		System.out.println("start "+start);
		System.out.println("end "+end);
		int midVal = arr[midIndex];
		if(midVal == midIndex) {
			return midIndex;
		}
		//to search left
		int leftIndex = Math.min(midVal, midIndex-1);
		int left =  magicIndex(arr, start, leftIndex);
		if(left >=0) {
			return left;
		}
		
		//to search right
		int rightIndex = Math.max(midVal, midIndex+1);
		return magicIndex(arr, start, rightIndex);
		
	}
	public static void main(String args[]) {
		int arr[] = {-10,-5,2,2,2,3,4,7,9,12,13};
		Arrays.sort(arr);
		int magicIndex = magicIndex(arr, 0, arr.length-1);
		System.out.println("the magic index is "+magicIndex);
		
	}
}
