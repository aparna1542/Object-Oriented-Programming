/**
 * 
 */
package cci.arrays.strings;

import java.util.Scanner;

/**
 * @author Aparna Ganesh
 * FIND THE MISSING NUMBER IN AN ARRAY OF NUM 1-100
 */
public class MissingNumberArray {

	/**
	 * SOLUTION : Step 1 : Find the sum of N natural numbers using formula n(n+1)/2
	 * Step 2 : Find the sum of all the numbers in the array
	 * Subtract step1 - step2. Thats the missing number 
	 */
	
	private static int sumOfNNatrualNum(int noOfElements) {
		
		int sum = (noOfElements * (noOfElements+1))/2;
		return sum;
	}
	
	private static int sumOfArrayElements(int arr[]) {
		
		int sum =0;
		for(int i=0;i<arr.length;i++) {
			sum = sum+arr[i];
		}
		return sum;
	}
	
	public static void main(String args[]) {
		
		System.out.println("Enter the number of Elements ");
		Scanner scanner = new Scanner(System.in);
		int noOfElements = scanner.nextInt();
		
		int sumOfNumbers = sumOfNNatrualNum(noOfElements);
		
		int[] arr = new int[5];
		System.out.println("Enter the array elements");
		for(int i=0;i<arr.length;i++) {
			arr[i] = scanner.nextInt();
		}
		int sumOfElements = sumOfArrayElements(arr);
		int missingNumner = sumOfNumbers - sumOfElements;
		System.out.println("The missing number is "+missingNumner);
	}
	
}
