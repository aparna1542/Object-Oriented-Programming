/**
 * 
 */
package cci.arrays.strings;

import java.util.Scanner;

/**
 * @author Aparna Ganesh
 *Class to compress a goven string
 *1. check if the compressed string is greater than given string, return the orig string.
 *2.Use StringBuffer since concatenation is faster than String
 *3.Print the result.
 */
public class StringCompressGood {
	
	public static void main(String args[]) {
		
		StringCompressGood scg = new StringCompressGood();
		System.out.println("Enter a string ");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		String result = scg.compressString(str);
		System.out.println("Compressed string is " + result);
	}

	/**
	 * To compress 
	 */
	private String compressString(String str) {
		// TODO Auto-generated method stub
		
		int size = countCompression(str);
		if(size > str.length()) {
			System.out.println("compressed string is greater than orig string !");
			return str;
		}
		StringBuffer sBuff = new StringBuffer();
		int count = 1;
		char first = str.charAt(0);
		for(int i = 1;i<str.length();i++) {
			
			if(str.charAt(i)== first) {
				count++;
			}
			else {
				sBuff.append(first);
				sBuff.append(count);
				count = 1;
				first = str.charAt(i);
			}
		}
		/* In lines 15 - 16 above, characters are inserted when the
		* repeated character changes. We
		* the end of the method as well,
		need to update the string at
		since the very last set of
		* repeated characters wouldn't be set in the compressed string
		* yet. */
		sBuff.append(first);
		sBuff.append(count);
		
		return sBuff.toString();
	}

	/**
	 * @param str
	 * @return
	 * Counts the size of compressed string
	 */
	private int countCompression(String str) {
		int size = 0;
		char first = str.charAt(0);
		int count = 1;
		
		for(int i =0;i<str.length();i++) {
			if(str.charAt(i)==first) {
				count++;
			}
			else {
				size = size + String.valueOf(count).length();
				first = str.charAt(i);
				count = 1;
			}
		}
		size = size + String.valueOf(count).length();
		return size;
	}

}
