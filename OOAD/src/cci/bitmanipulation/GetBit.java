/**
 * 
 */
package cci.bitmanipulation;

/**
 * @author Aparna Ganesh
 *
 */
public class GetBit {

private static boolean getBit(int num, int i) {
	int answer = num & (1 << i);
	if(answer !=0) {
		return true;
	}
		return false;
		 }
public static void main(String args[]) {
	boolean result = getBit(4,2);
	if(result) {
		System.out.println("true");
	}
	else {
		System.out.println("False");
	}
}
}
