package Algo.DS;
/**
 * 
 * Program that implements MAX SUB ARRAY using Brute Force and Divide & Conquer techniques
 *
 */
public class MaxSubArray {

	private static int arr[]={13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};

	/**
	 *  Brute force algorithm to find maximum subarrya
	 * @return array[max_sum,max_left,max_right] 
	 */
	public int[] bruteForceMaxSubArray()
	{
		int max_sum=0,max_i=0,max_j=0,temp;

		for (int i=0;i<arr.length;i++) 
		{
			temp=arr[i];
			for(int j=i+1;j<arr.length;j++)
			{
				temp=temp+arr[j];
				if(temp>max_sum)
				{
					max_sum=temp;
					max_i=i;
					max_j=j;

				}
			}

		}
		return new int[]{max_sum, max_i, max_j};
		
	}
	
	/**
	 *  Recursive method to calculate Maximum Subarray using Divide&Conquer technique
	 * @param array
	 * @param low
	 * @param high
	 * @return array[max_sum,max_left,max_right]
	 */
	public int[] findMaximumSubArray(int[] array, int low, int high ) {
		System.out.println("findMaximumSubArray("+low+","+high+")");
		if(high == low) {
			System.out.println("base case: returning ("+array[low] + "," + low + ","+ high + ")");
			return new int[]{array[low],low,high};
		}
		else {
			int mid = (low + high)/2;
			int[] leftSubArray = findMaximumSubArray(array, low, mid);
			int[] rightSubArray = findMaximumSubArray(array, mid + 1, high);
			int[] crossingSubArray = findCrossingSubArray(array,low,mid,high);
			System.out.println("Finding max subarray among:");
			printArray(leftSubArray);
			printArray(rightSubArray);
			printArray(crossingSubArray);
			System.out.println("Found max subarray: ");
			if(leftSubArray[0] > rightSubArray[0] && leftSubArray[0] > crossingSubArray[0]) {
				printArray(leftSubArray);
				return leftSubArray;
			}
			else if(rightSubArray[0] > leftSubArray[0] && rightSubArray[0] > crossingSubArray[0]) {
				printArray(rightSubArray);
				return rightSubArray;
			}
			else {
				printArray(crossingSubArray);
				return crossingSubArray;
			}
			
		}
	}

private void printArray(int[] array ) {
	System.out.println();
	System.out.print("[");
	for(int a : array) {
		System.out.print(a + " ");
	}
	System.out.print("]");
	System.out.println();
}
	
/**
 *  Method to find the maximum crossing subarray
 * @param array
 * @param low
 * @param mid
 * @param high
 * @return array[max_sum,max_left,max_right]
 */
	private int[] findCrossingSubArray(int[] array, int low, int mid, int high) {
		System.out.println("findCrossingSubArray("+low + "," + mid + "," + high + ")");
		int leftSum = Integer.MIN_VALUE;
		int sum = 0;
		int maxLeft = 0;
		for(int i = mid; i >= low; i--) {
			sum = sum + array[i];
			if(sum > leftSum) {
				leftSum = sum;
				maxLeft = i;
				
			}
		}
		int rightSum = Integer.MIN_VALUE;
		int maxRight = 0;
		sum = 0;
		for(int j = mid + 1; j <= high; j++) {
			sum = sum + array[j];
			if(sum > rightSum) {
				rightSum = sum;
				maxRight = j;
			}
		}
		int[] result = {leftSum + rightSum, maxLeft, maxRight};
		System.out.println("Found max crossing sub array :");
		printArray(result);
		return result;
	}

	public static void main(String args[])
	{
		MaxSubArray m= new MaxSubArray();
		System.out.println("-------Max Subarray using Brute Force method-------");
		int[] result = m.bruteForceMaxSubArray();
		System.out.println("Sum of Maximum sub array(Brute Force) = "+result[0]);
		System.out.println("Start Index = "+result[1]);
		System.out.println("End Index = "+result[2]);
		
		System.out.println("-------Max Subarray using Divide & Conquer method-------");
		result = m.findMaximumSubArray(arr, 0, arr.length-1);
		System.out.println("Sum of Maximum sub array(Divide & Conquer) = "+result[0]);
		System.out.println("Start Index = "+result[1]);
		System.out.println("End Index = "+result[2]);
	}

}
