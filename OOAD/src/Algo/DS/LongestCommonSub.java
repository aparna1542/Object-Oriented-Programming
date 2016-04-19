package Algo.DS;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSub {

	/**
	 * takes two strings from user and stores in char array.
	 * Computes the length of common subsequence.
	 * @param x
	 * @param y
	 */
	public static List<Object> findLCS(char [] x, char [] y){

		int m=x.length;
		int n=y.length;
		int [][] b=new int[m+1][n+1];
		int [][] c=new int[m+1][n+1];
		List<Object> result = new ArrayList<>();

		//the first 0 in the matrix is common for both so i=1 to m and j=0 to n
		for(int i=1;i<=m;i++) {
			c[i][0]=0;
		}
		for(int j=0;j<=n;j++) {
			c[0][j]=0;
		}
		for (int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
			//	System.out.println("("+i+"," + j+ ")");
				//System.out.println(x[i-1] + "==" + y[j-1]);
				if(x[i-1]==y[j-1]) {
					c[i][j]=c[i-1][j-1] + 1;
					b[i][j]=2; // diagonal
				}
				else if(c[i-1][j] >= c[i][j-1]) {
					c[i][j] =c[i-1][j];
					b[i][j]=3; // up arrow 
				}
				else {
					c[i][j]= c[i][j-1];
					b[i][j]=4; //left arrow
				}
			}
		}
		result.add(c);
		result.add(b);
		return result;
	}

	public static void printLCS(int [][] b,char [] x,int i,int j) {
		
		if(i==0 || j==0) {
			return;
		}
		if (b[i][j]==2) {
			printLCS(b,x,i-1,j-1);
			System.out.print("\t" + x[i-1]);
		}
		else if (b[i][j]==3) {
			printLCS(b,x,i-1,j);
		}
		else printLCS(b,x,i,j-1);
	}


	public static void main(String[] args) {

		String x="abcbdab";
		String y="bdcaba";

		List<Object> result=findLCS(x.toCharArray(), y.toCharArray());
		int c[][] = (int[][])result.get(0);
		int b[][] = (int [][])result.get(1);
		
		System.out.println("The c[i][j] grid is ");
		for(int i=0;i<=x.length();i++) {
			System.out.println();
			for(int j=0;j<=y.length();j++) {
				System.out.print("\t" + c[i][j]);
			}
		}
		System.out.println();
		//System.out.println("============================================================");
		
		/*for(int i=0;i<=x.length();i++) {
			System.out.println();
			for(int j=0;j<=y.length();j++) {
				System.out.print("\t" + b[i][j]);
			}
		}*/
System.out.println(" \n the length of LCS is " + c[x.length()][y.length()]);
System.out.println("\n A Longest common subsequence is ");
printLCS(b, x.toCharArray(), x.length(), y.length());





	}
}