/**
 * 
 */
package cci.java;

/**
 * @author Aparna Ganesh
 * static blocks are used to initiaze static members of the class
 * Even if we dont create obj for the class, since we are accesing static var, static 
 * block gets exec.
 * constructor gets called only after static block is exec
 */
public class StaticBlockDemo {

	private static int i;
	
	public StaticBlockDemo() {
		i = 9;
		System.out.println("Inside the constructor");
	}
	static {
		
		System.out.println("Inside static block");
	}
	public static void main(String args[]) {
		System.out.println("Printing static var "+i);
		StaticBlockDemo sd = new StaticBlockDemo();
		
	}
}
