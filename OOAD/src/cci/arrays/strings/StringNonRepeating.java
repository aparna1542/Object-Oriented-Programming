/**
 * 
 */
package cci.arrays.strings;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Program to find first non repeating charactr in a String using LinkedHashMap
 * @author Aparna Ganesh
 *
 */


/**
 * Algo 1:traverse through the string and build a hash map as char as key and its count as val
 * 2: Iterate the hash map and the character that has count 1 is the first non repeating as linked
 * hash map maintains order
 */
public class StringNonRepeating {

	private static char findNonRepeatingChar(String str) {
		
		Map<Character,Integer> linkedHashMap = new LinkedHashMap<>();
		char[] charArray = str.toCharArray();
		
		//if it already has the char as key then incr its val by 1 else 1
		for(char c : charArray) {
			linkedHashMap.put(c, linkedHashMap.containsKey(c) ? linkedHashMap.get(c) + 1 : 1);
			
		}
		
		//iterate through the HashMap to find the non repeating char
		for (Entry<Character,Integer> entry : linkedHashMap.entrySet()) {
			
			if(entry.getValue() == 1) {
				return entry.getKey();
			}
			
		}
		System.out.println("No match found");
		return 0;
		
	}
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the string ");
		String str = scanner.nextLine();
		
		char nonRepeatingChar = findNonRepeatingChar(str);
		System.out.println("The first non repeating char is "+nonRepeatingChar);
	}
}
