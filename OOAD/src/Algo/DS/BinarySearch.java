/**
 * 
 */
package Algo.DS;

import java.util.Scanner;

/**
 * @author Aparna Ganesh
 * Binary Search -Iterative
 */
public class BinarySearch {

	public static int binarySearch(int arr[],int x) {
		int low = 0;
		int high = arr.length -1;
		
		while(low <=high) {
			int mid = (low+high)/2;
			if(arr[mid] == x) {
				return mid;
			}
			else if(arr[mid] < x) {
				low = mid+1;
			}
			else high = mid - 1;
		}
		
		return -1;
	}
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the array size ");
		int size = scanner.nextInt();
		int arr[] = new int[size];
		System.out.println("Enter the array ele ");
		for(int i=0;i<size;i++) {
			arr[i] = scanner.nextInt();
		}
		int index = BinarySearch.binarySearch(arr, 6);
		System.out.println("Element found on index " + index);
	}
}
