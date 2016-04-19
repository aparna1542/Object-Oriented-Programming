/**
 * 
 */
package cci.recursion.dp;

/**
 * @author Aparna Ganesh
 * Given a sorted arr of distinct integers,find magic index if any
 * a[i] = i means i is the magic index
 */
public class MagicIndexDistint {

	public static int magicIndex(int[] arr,int start,int end) {
		if(start <0 || end >= arr.length || end <start) {
			return -1;
		}
		int mid = (start+end) /2;
		if(arr[mid]==mid) {
			return mid;
		}
		else if(arr[mid] > mid) {
			return magicIndex(arr, start, mid-1);
		}
		else {
			return magicIndex(arr, mid+1, end);
		}
		
	}
	public static void main(String args[]) {
		int[] arr = {-40,-20,-1,1,2,3,5,7};
		
		int magicIndex = magicIndex(arr,0, arr.length-1);
		System.out.println("Magic index is "+magicIndex);
	}
}
