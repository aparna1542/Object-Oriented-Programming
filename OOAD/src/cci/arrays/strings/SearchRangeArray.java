/**
 * 
 */
package cci.arrays.strings;

/**
 * @author Aparna Ganesh
 * Given a sorted array, find range of a target element
 */
public class SearchRangeArray {
	
	
	public static int[] searchRange(int[] inputArr,int targetVal) {
		int[] arr= new int[2];
		arr[0] = -1;
		arr[1] = -1;
		binarySearch(inputArr,targetVal,arr,0,inputArr.length-1);
		return arr;
	}

	
	private static void binarySearch(int[] inputArr, int targetVal, int[] arr, int start,int end) {
		//base case
		if(start>end) {
			return;
		}
		//if start and end vals are same
		if(inputArr[start]==inputArr[end] && inputArr[start]==targetVal) {
			arr[0]= start;
			arr[1]= end;
			return;
		}
		int mid = start+(end-start)/2;
		//if target val is greater than mid,search RHS
		if(inputArr[mid]<targetVal) {
			binarySearch(inputArr, targetVal, arr, mid+1, end);
		}
		else if(inputArr[mid]>targetVal) {
			binarySearch(inputArr, targetVal, arr, start, mid-1);
		}
		else { //if target is mid,
			arr[0]=mid;
			arr[1]=mid;
			//handle duplicated to the LHS
			int t1= mid;
			while(start <t1 && inputArr[t1]==inputArr[t1-1]) {
				t1--; //decrement mid till we find the correct start
				arr[0] = t1;
				}
			
			//handle duplicates to the RHS
			int t2= mid;
			while(t2<end && inputArr[t2]==inputArr[t2+1]) {
				t2++; //decrement mid till we find the correct start
				arr[1] = t2;
				}
			return;
		}
	}
	public static void main(String args[]) {
		int[] inputArr = {1,2,3,4,5,5,5,7};
		int[] range = searchRange(inputArr, 5);
		System.out.println("Output");
		System.out.print("[");
		for(int i:range) {
			System.out.print(i+",");
		}
		System.out.print("]");
	}

}
