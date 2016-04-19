/**
 * 
 */
package cci.sort.search;

import java.util.Arrays;

/**
 * @author Aparna Ganesh
 *
 */
public class SortStringArrayAnagram {

	public static String printStringArray(String[] stringArray) {
		StringBuilder builder = new StringBuilder();
		for(String s:stringArray) {
			builder.append(s+",");
		}
		return builder.toString();
	}
	
	public static void main(String args[]) {
		String names[] = {"kiwi","apple","leppa","art","bank","ele","lee","eel"};
		Arrays.sort(names,new AnagramComperator());
		System.out.println(SortStringArrayAnagram.printStringArray(names));
		}
	}

