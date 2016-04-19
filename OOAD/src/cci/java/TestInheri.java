/**
 * 
 */
package cci.java;

/**
 * @author Aparna Ganesh
 *
 */
public class TestInheri {

	private TestInheri() {
		System.out.println("This class cannot be inherited");
	}
	public static TestInheri test() {
		return new TestInheri();
	}
	public static void main(String args[]) {
		TestInheri.test();
	}
}
