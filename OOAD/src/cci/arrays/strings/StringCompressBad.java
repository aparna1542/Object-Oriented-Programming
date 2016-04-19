/**
 * 
 */
package cci.arrays.strings;

import java.util.Scanner;

/**
 * @author Aparna Ganesh
 * Idea is to iterate through the string,copying characters to new string,
 * and counting repeats.
  */
public class StringCompressBad {

	public static String compressBad(String str) {
		
		String emptyStr = "";
		char first = str.charAt(0);
		int count = 1;
		for(int i=1;i<str.length();i++) {
			
			if(str.charAt(i)==first) {
				count++;
			}
			else {
				// this is where we append the character,its count to the new empty string
				emptyStr = emptyStr + first + "" + count; 
				first = str.charAt(i);
				count = 1;
			}
		}
		return emptyStr + first +count;
	}
	public static void main(String args[]) {
		
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter the string to compress ");
	String str = scanner.nextLine();
	String result = compressBad(str);
	System.out.println("The compressed String is "+result);
	
	
}
}