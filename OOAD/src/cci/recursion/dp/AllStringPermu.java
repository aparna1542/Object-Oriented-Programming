package cci.recursion.dp;

import java.util.ArrayList;

/**
 * @author Aparna Ganesh
 * Program to find all string permutations
 * Take the first char and insert in all postions of the permutations of the remaining char
 * this can be done recursively
 */
public class AllStringPermu {

	public static ArrayList<String> getAllPermu(String str) {
		if(str==null) {
			return null;
		}
		ArrayList<String> permu = new ArrayList<>();
		if(str.length()==0) {
			permu.add("");
			return permu;
		}
		char first = str.charAt(0); //getting the first char
		String reminder = str.substring(1);// remaining char
		//going recursively to get permu of reminaing string
		ArrayList<String> words = getAllPermu(reminder); 
		
		for(String word:words){ //iterate the arraylist of permutations
			for(int i=0;i<=word.length();i++) {
				String s = insertWordAt(word,first,i);
				permu.add(s); //final permutations
			}
		}
		return permu;
	}
	
	public static String insertWordAt(String word,char firstChar,int i) {
		String start = word.substring(0,	 i);
		String end = word.substring(i);
		return start+firstChar+end;
	}
}
