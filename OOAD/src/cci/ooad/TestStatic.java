/**
 * 
 */
package cci.ooad;

/**
 * @author Aparna Ganesh
 *
 */
/* Java program to show that if static methods are redefined by
a derived class, then it is not overriding but hidding. */

// Superclass
class TestStatic {
	
	// Static method in base class which will be hidden in subclass 
	public static void display() {
		System.out.println("Static or class method from Base");
	}
	
	// Non-static method which will be overridden in derived class 
	public void print() {
		System.out.println("Non-static or Instance method from Base");
	}
}

/*// Subclass
class Derived extends TestStatic {
	
	// Static is removed here (Causes Compiler Error) 
	public void display() {
		System.out.println("Non-static method from Derived");
	}
	
	// Static is added here (Causes Compiler Error) 
	public static void print() {
		System.out.println("Static method from Derived");
}
}*/
