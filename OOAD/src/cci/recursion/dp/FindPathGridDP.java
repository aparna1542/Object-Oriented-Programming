/**
 * 
 */
package cci.recursion.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Aparna Ganesh
 * Recursive soln to find if there is a path from soruce to dest for a Robo to 
 * travel in a grid. We start from end and trace if there is a path
 */
public class FindPathGridDP {
	
	public static int[][] maze = new int[10][10];
	
	public static boolean isFree(int x,int y) {
		if (maze[x][y] == 0) { //mechanism to indicate blocked cells
			return false;
		} else {
			return true;
		}
	}
	
	public static int[][] randomMatrix(int M, int N, int min, int max) {
		int[][] matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = randomIntInRange(min, max);
			}
		}
		return matrix;
	}


	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] < 10 && matrix[i][j] > -10) {
					System.out.print(" ");
				}
				if (matrix[i][j] < 100 && matrix[i][j] > -100) {
					System.out.print(" ");
				}
				if (matrix[i][j] >= 0) {
					System.out.print(" ");
				}
				System.out.print(" " + matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public static boolean getPath(int x,int y,ArrayList<Point> path,HashMap<Point,Boolean> hmap) {
		Point p = new Point(x,y);
		
		if(hmap.containsKey(p)) {
			return hmap.get(p); //returning the cached result
		}
		if(x==0 && y==0) { 
			return true; //path found (0,0) ORigin
		}
		boolean success = false;
		if(x >=1 && isFree(x-1,y)) { //go left check out of bounds
			success = getPath(x-1,y,path,hmap); //if free add to path
	
		}
		if(!success && y >=1 && isFree(x,y-1)) { //go top
			success = getPath(x,y-1,path,hmap); //if free add to path
	
		}
		if(success) {
			path.add(p);
			return true;		
		}
		hmap.put(p, success); //cahching the result
	return success;
	}

	public static void main(String args[]) {
		int size = 5;
		maze = randomMatrix(size, size, 0, 5);
		printMatrix(maze);
		
		ArrayList<Point> path = new ArrayList<>();
		HashMap<Point, Boolean> hmap = new HashMap<>();
		
		boolean result = FindPathGridDP.getPath(size -1,size -1, path,hmap);
		if(result) {
			System.out.println("Path found");
			
		}
		else
			System.out.println("No path found");
	}
}
