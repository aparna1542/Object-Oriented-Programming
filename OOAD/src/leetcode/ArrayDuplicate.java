/**
 * 
 */
package leetcode;

import java.util.HashSet;

/**
 * @author Aparna Ganesh
 * Program to check if a given array contains duplicate or not
 */
public class ArrayDuplicate {

	public static boolean checkDuplicate(int[] arr) {
		//check if arr is null
		if(arr.length==0 || arr==null) {
			return false;
		}
		HashSet<Integer> hs = new HashSet<>();
		for(int i:arr) {
			if(!hs.add(i)) {
				return true;
			}
		}
		return false;
	}
	public static void main(String args[]) {
		int arr[] = {1,1,2,3};
		boolean result = checkDuplicate(arr);
		if(result) {
			System.out.println("Contains duplicate");
		}
		else {
			System.out.println("No duplicate ele");
		}
	}
}
