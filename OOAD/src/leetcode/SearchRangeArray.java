/**
 * 
 */
package leetcode;

/**
 * @author Aparna Ganesh
 *
 */
public class SearchRangeArray {
	public static int[] searchRange(int[] inputArr, int target) {
	    if(inputArr == null || inputArr.length == 0){
	        return null;
	    }
	 
	    int[] arr= new int[2];
	    arr[0]=-1;
	    arr[1]=-1;
	 
	    binarySearch(inputArr, 0, inputArr.length-1, target, arr);
	 
	    return arr;
	}
	 
	public static void binarySearch(int[] nums, int start, int end, int target, int[] arr){
	    if(end<start) 
	        return;
	 
	    if(nums[start]==nums[end] && nums[start]==target){
	        arr[0]=start;
	        arr[1]=end;
	        return;
	    }
	 
	    int mid = start+(end-start)/2;
	 
	 
	    if(nums[mid]<target){
	        binarySearch(nums, mid+1, end, target, arr);
	    }else if(nums[mid]>target){
	        binarySearch(nums, start, mid-1, target, arr);
	    }else{
	        arr[0]=mid;
	        arr[1]=mid;
	 
	        //handle duplicates - left
	        int t1 = mid;
	        while(t1 >start && nums[t1]==nums[t1-1]){
	            t1--;
	            arr[0]=t1;
	        }
	 
	        //handle duplicates - right
	        int t2 = mid;
	        while(t2 < end&& nums[t2]==nums[t2+1]){
	            t2++;
	            arr[1]=t2;
	        }
	        return;
	    }
	}

	public static void main(String agrs[]) {
		
		int arr[] = {1,2,3,4,5,6,7,8,8,8,9};
		int res[] = searchRange(arr, 9);
		System.out.println("Start and end range is ");
		for(int i:res) {
			System.out.println(i);
		}
	}
}
