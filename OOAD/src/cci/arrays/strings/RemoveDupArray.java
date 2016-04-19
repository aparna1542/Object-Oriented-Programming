/**
 * 
 */
package cci.arrays.strings;

import java.util.Arrays;

/**
 * @author Aparna Ganesh
 * Remove duplicate elements from a sorted array.
 * We can compare each ele with its next ele since its sorted
 */
public class RemoveDupArray {

	//aproach 1, calc all unique ele alone and return the array
	public static int[] getAllUniqueEle(int[] arr) {
		if(arr.length<2) {
			return arr;
		}
		int i=1; int j=0;
		while(i<arr.length) {
			if(arr[i]==arr[j]) {
				i++;
			}
			else {
				j++;
				arr[j]=arr[i];
				i++;
			}
		}
		int[] b=Arrays.copyOf(arr, j+1);
		return b;
	}
	//approach 2 count the duplicate ele alone and subtract from arr ele,and  return the length
	public static int getLength(int[] arr) {
		int count=0;
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]==arr[i+1]) {
				count++;
			}
		}
		return arr.length-count;
		
	}
public static void main(String args[]) {
	int[] arr = {1,1,2,3};
	System.out.println("Length of unique ele is "+getLength(arr));
	System.out.println("Unique ele are ");
	int[] result =getAllUniqueEle(arr);
	for(int i =0;i<result.length-1;i++) {
		System.out.print(result[i]+" ");
	}
}
}

