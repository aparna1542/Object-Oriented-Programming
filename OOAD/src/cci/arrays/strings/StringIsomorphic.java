package cci.arrays.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Aparna Ganesh
 * Check whether the given string is isomorphic or not.	
 */
public class StringIsomorphic {

	/**
	 * Step 1 : Check whether the given two strings are of same length
	 * Step 2 : Go over every character of both strings and store them as <k,v> in HashMap if already not present
	 * Step 3 : The value of String1 shud match the every charac in String2
	 */
	
	public static boolean isIsomorphic(String str1, String str2) {
		
		Map<Character,Character> charMap = new HashMap<>();
		
		int length1 = str1.length();
		int length2 = str2.length();
		
		if(length1 != length2) {
			return false;
		}
		
		for(int i=0; i<length1;i++) {
			
			if(!charMap.containsKey(str1.charAt(i)) && !charMap.containsKey(str2.charAt(i))) {
				
				charMap.put(str1.charAt(i), str2.charAt(i));
			}
			
			if(charMap.get(str1.charAt(i)) == null) {
				return false;
			}
			
			if(!charMap.get(str1.charAt(i)).equals(str2.charAt(i))) {
				return false;
			}
			
		}
		return true;
		
	}
	
	public static void main(String args[]) {
		System.out.println("Enter String 1 "); 
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.nextLine();
		System.out.println("Enter String 2 ");
		String str2 = scanner.nextLine();
		boolean result = isIsomorphic(str1,str2);
		if(result) {
			System.out.println("The given strings are isomorphic ");
		}
		else
			System.out.println("Not Isomorphic !");
	}
}
