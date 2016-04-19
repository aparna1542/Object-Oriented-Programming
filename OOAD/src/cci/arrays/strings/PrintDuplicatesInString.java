/**
 * 
 */
package cci.arrays.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Program to print duplicate characters in a String
 *@author Aparna Ganesh
 */
public class PrintDuplicatesInString {
	
	
	private static void printDuplicate(String str) {
		
		char[] charArr = str.toCharArray();
		HashMap<Character,Integer> hmap = new HashMap<>();
		
		//To build the hash map with character and count
		for(char c : charArr) {
			
			if(hmap.containsKey(c)) {
				hmap.put(c, hmap.get(c)+1);
			}
			else
				hmap.put(c, 1);
		}
		
		//iterate through the map to print duplicates
		
		Set<Map.Entry<Character,Integer>> entrySet = hmap.entrySet();
		
		for(Map.Entry<Character, Integer> entry : entrySet) {
			if(entry.getValue() > 1) {
				System.out.println("The duplicate char is '"+entry.getKey()+" 'the count is "+entry.getValue());
			}
		}
	}
	
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string ");
		String str = scanner.nextLine();
		printDuplicate(str);
	}

}
