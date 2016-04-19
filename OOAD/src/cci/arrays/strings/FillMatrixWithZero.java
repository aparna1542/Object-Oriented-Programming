/**
 * 
 */
package cci.arrays.strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Aparna Ganesh
 *If any element of the 2D Matrix is 0, then fill the entire row and col with 0.
 */
public class FillMatrixWithZero {

	private static void fillWithZeros(int[][] matrix) {
		
		boolean[] row = new boolean[9];
		boolean[] col = new boolean[9];
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(matrix[i][j]==0) {
					row[i] = true;
					col[j] = true;
				}
			}
		}
		
		for (int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(row[i] || col[j]) {
					matrix[i][j] =0;
				}
			}
		}
	}
	public static void main(String args[]) {
		
	Scanner scanner = new Scanner(System.in);
	int[][] matrix = new int[3][3];
	System.out.println("enter the elements for 3x3 matrix ");
	for(int i=0;i<matrix.length;i++) {
		for(int j=0;j<matrix[0].length;j++){
			matrix[i][j] = scanner.nextInt();
		}
	}
	fillWithZeros(matrix);
	System.out.println("the elements are "+Arrays.deepToString(matrix));
	}
	
}
