/**
 * 
 */
package cci.arrays.strings;

import java.util.Scanner;

/**
 * @author Aparna Ganesh
 * To Check if s2 is rotaion of s1 or not
 */
public class StringRotationCheck {

	//check if given string is the substring of another
	
	private boolean isSubString(String s1,String s2) {
		
		if(s1.contains(s2)) {
			return true;
		}
		return false;
		
	}
	
	private boolean stringRotationCheck(String s1,String s2) {
		
		if(s1.length() == s2.length() && s1.length()>0 && s2.length()>0) {
			StringBuffer sBuff = new StringBuffer();
			sBuff.append(s1);
			sBuff.append(s1);
			return isSubString(sBuff.toString(), s2);
			
			
		}
		else {
		System.out.println("String not of same length or is empty");
		return false;
		}
	}
	public static void main(String args[]) {
		
		StringRotationCheck scr = new StringRotationCheck();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter String s1 ");
		String s1 = scanner.nextLine();
		System.out.println("Enter String s2 ");
		String s2 = scanner.nextLine();
		boolean result = scr.stringRotationCheck(s1, s2);
		if(result) {
			System.out.println("String "+s2+ " is roation of "+ s1);
		}
		else
			System.out.println("String "+s2+ " is not roation of "+ s1);
	}
}
