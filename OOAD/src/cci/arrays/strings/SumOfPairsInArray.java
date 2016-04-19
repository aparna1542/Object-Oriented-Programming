/**
 * 
 */
package cci.arrays.strings;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Aparna Ganesh To find pairs of distinct integers in an array whose
 *         sum is the same Eg: [3,4,5,6,7,1] pairs are(4,3) and (1,6) If there
 *         are multiple pairs print any/all
 */

//Code has bug!!

public class SumOfPairsInArray {

	private class Pairs {

		int first, second;

		public Pairs(int f, int s) {
			f = first;
			s = second;

		}

	};

	public void findPairs(int[] arr) {

		boolean flag = false;
		HashMap<Integer, Pairs> hMap = new HashMap<>();
		// traverse through the array
		int n = arr.length;

		// Traverse through all possible pairs of arr[]
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				// If sum of current pair is not in hash,
				// then store it and continue to next pair
				int sum = arr[i] + arr[j];
				if (!hMap.containsKey(sum))
					hMap.put(sum, new Pairs(i, j));

				else // Else (Sum already present in hash)
				{
					// Find previous pair
					Pairs p = hMap.get(sum);

					// Since array elements are distinct, we don't
					// need to check if any element is common among pairs
					System.out.println("(" + arr[p.first] + ", "
							+ arr[p.second] + ") and (" + arr[i] + ", "
							+ arr[j] + ")");
					flag = true;

				}
			}
		}
		if (!flag) {
			System.out.println("No Pairs found");
		}
	}

	public static void main(String args[]) {

		SumOfPairsInArray spa = new SumOfPairsInArray();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the array size ");
		int size = scanner.nextInt();
		System.out.println("Enter the array elements ");
		int[] arr = new int[size];
		for (int i : arr) {
			arr[i] = scanner.nextInt();
		}
		spa.findPairs(arr);
	}
}
