/**
 * 
 */
package cci.sort.search;

/**
 * @author Aparna Ganesh
 *
 */

import cciLibrary.*;

public class FindEleSortedMatrix {

	public static boolean findElement(int[][] matrix, int elem) {
		int row = 0;
		int col = matrix[0].length - 1; 
		while (row < matrix.length && col >= 0) {
			if (matrix[row][col] == elem) {
				return true;
			} else if (matrix[row][col] > elem) {
				col--;
			} else {
				row++; 
			}
		} 
		return false; 
	}
	
	public static void main(String[] args) {
		int M = 4;
		int N = 4;
		int[][] matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = 10 * i + j;
			}
		}
		
		AssortedMethods.printMatrix(matrix);
		boolean result = findElement(matrix, 44);
		if(result) {
			System.out.println("Ele found");
		}
		else
			System.out.println("Not found");
	
		
	}

}

