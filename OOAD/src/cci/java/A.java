/**
 * 
 */
package cci.java;



/**
 * @author Aparna Ganesh
 * cannot inherit from a base class that has a private constructor
 */
public class A  { 
	
	public static void print() {
		System.out.println("Testing private constructor"+TestInheri.test());
	}
	public static void main(String args[]) {
		A.print();
	}
}
