/**
 * 
 */
package cci.arrays.strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Aparna Ganesh
 *
 */
public class PrintTwoDArray {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of rows: ");
		int Rows = input.nextInt();
		System.out.print("Enter the number of columns: ");
		int Columns = input.nextInt();

		int[][] array = new int[Rows][Columns];

		for (int i = 0; i < array.length; i++) {
			System.out.println("enter the numbers for row " + (i + 1) + ":");
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = input.nextInt();

			}
			

		}
		System.out.println(Arrays.deepToString(array));
	}
}
