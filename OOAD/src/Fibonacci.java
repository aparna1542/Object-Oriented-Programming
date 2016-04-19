/**
 * 
 */

/**
 * @author Aparna Ganesh
 *
 */
public class Fibonacci {
	public static int fib (int n) {
	    int fib = 0;
	    int a = 1;
	    for(int i=0; i<n; i++) {
	       fib = fib + a;
	       a = fib;
	    }
	    return fib;
	}
	public static void main(String args[]) {
		System.out.println("Result"+fib(4));
		
	}
}
