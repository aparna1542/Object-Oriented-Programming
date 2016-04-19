package Algo.DS;

/**
 * 
 * Counting Sort Impl
 * Bugs in program
 *
 */
public class CountingSort {

	// pass the input array and Range-K
	public int[] countingSort(int a[], int k) {
		int c[] = new int[k];
		int b[] = new int[15];
		int prefix_sum[] = new int[k];
		int i, j;
		// initializing Count array
		for (i = 0; i < k; i++) {
			c[i] = 0;
		}
		// Counting the numb of occurances into Count array
		System.out.println("The count array is ");
		for (j = 0; j < a.length; j++) {
						c[a[j]] = c[a[j]] + 1;
		}
		for(j = 0; j < k; j++) {
			System.out.print("\t" + c[j]);
		}
		
		
		// Compute the prefix sum
		prefix_sum[0] = c[0];
		for (i = 1; i < k; i++) {
			prefix_sum[i] = c[i] + prefix_sum[i - 1];
		}
		System.out.println("\nthe prefix sum is ");
		for(j = 0; j < k; j++) {
			System.out.print("\t " +prefix_sum[j]);
		}
		
		// traverse the array from a.length to 1(stability) and put in final
		// array
		System.out.println("\nThe sorted array is ");
		for (j = a.length-1; j >= 0; j--) {
			b[prefix_sum[a[j]]] = a[j];
			prefix_sum[a[j]] = prefix_sum[a[j]] - 1;
		}
		for(i=0;i<=a.length;i++) {
			System.out.print("\t" +b[i]);
		}

		return a;
	}

	public static void main(String args[]) {
CountingSort c = new CountingSort();
int a[] ={4,6,7,8,3,2,3,9,1,9,2,5};
c.countingSort(a, 10);
}
}
