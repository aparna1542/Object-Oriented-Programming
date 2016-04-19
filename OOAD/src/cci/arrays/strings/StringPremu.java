/**
 * 
 */
package cci.arrays.strings;

import java.util.Scanner;

/**
 *To check whether is the given string is the permutation (String anagram) of other 
 * using character count match.
 * @author Aparna Ganesh
 *
 */
public class StringPremu {

	/**
	 * Step 1: Basic string length check
	 * Step 2: Traverse the Charac array and store the charac count (ASCII value will be array index),
	 * increment it 
	 * Step 3: For the second string decrement the charac count,if found in that index,if count<0, return false	
	 */
	
	public static boolean stringPermu(String str1,String str2) {
		if(str1.length() != str2.length()) {
			System.out.println("String length not same !");
			return false;	
		}
		int[] charCount = new int[256];
	
		for(char c : str1.toCharArray()) {
			charCount[c]++;
		}
		
		for(char c : str2.toCharArray()) {
			
			if(--charCount[c] < 0) {
				System.out.println(str1 + " is not a permutation of " + str2);
				return false;
			}
		}
		
		System.out.println(str1 + " is a permutation of " + str2);
		return true;
	}
	public static void main (String args[]) {

		String str1,str2;
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter the strings :");
		str1 = scanner.nextLine();
		str2 = scanner.nextLine();
		
		stringPermu(str1,str2);
		
		
		
	}
}
