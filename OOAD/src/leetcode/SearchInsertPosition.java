/**
 * 
 */
package leetcode;

/**
 * @author Aparna Ganesh
 * Search insert position in a sorted array
 */
public class SearchInsertPosition {

	public int serachPositionNaive(int[] arr,int target) {
		for(int i=0;i<arr.length-1;i++) {
			if(target ==arr[i]) { //if that ele is the target,return its index
				return i;
			}
			else if(target>arr[i] && target <=arr[i+1]) { //if target is in between
				return i+1;
			}
			else {
				// do nothing
			}
		}
		return -1;
	}
	
	public int searchInsertPositionBS(int[] arr,int target) {
		return searchPostionBS(arr,target,0,arr.length-1);
	}
	public int searchPostionBS(int[] arr,int target,int start,int end) {
		int mid = (start+end)/2;
		if(target ==arr[mid]) {
			return mid;
		}
		else if(target <arr[mid]) {
			return start<mid ? searchPostionBS(arr, target, start, mid-1):start;
		}
		else {
			return end>mid ? searchPostionBS(arr, target, mid+1, end):end+1;
		}
	}
}
