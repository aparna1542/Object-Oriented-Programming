/**
 * 
 */
package cci.java;

/**
 * @author Aparna Ganesh
 *
 */
public class TestFinal {
	
	int i =30;
	final  int j = 3;
	public static void main(String args[]) {
		final TestFinal t1 = new TestFinal();
		TestFinal t2 = new TestFinal();
	//	t1 = t2; cannot be assigned to another ref var
		t1.i =40; // its member var can be changed
	//	t1.j =5; // cannot reassign
	}

}
