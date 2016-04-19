/**
 * Handling Exceptions Demo Program
 */
package ExceptionsDemoPgm;

class Counter1{
		private int count = 0;
		public Counter1(int count) { this.count = count;};

		// The method increment () declares that it throws an exception
		public void increment(double amount)throws IllegalArgumentException,NullPointerException {
                  if ( amount < 0){
			    throw new IllegalArgumentException("Negative amount not accepted");
                  }
			    else{ 
			    	throw new NullPointerException("to test NumberFormatException");
                  }
               //   count += amount;
		}
		
		public int getCount(){ return count;}
		
		public  static void test1() throws IllegalArgumentException{
		    Counter1 oneCounter = new Counter1(2);		    
		    oneCounter.increment (-1);	   
		    System.out.println ("test1: Count = "+oneCounter.getCount());
		}
		
		public static void test2() {
		    Counter1 oneCounter = new Counter1(2);
		    // Handling the exception by enclosing the method call
		    // in a try- catch block
		    // try block encloses the code that might potentially
		    // throw an exception
		    try {
		        oneCounter.increment (-1);
		    }
		    // catch- block encloses the code that will handle
		    // the exception
		    catch (IllegalArgumentException | NullPointerException e){
                  System.out.println ("test2:Catch Block: Exception handled here");
		          System.out.println (e);
                  e.printStackTrace();
		    }
		    // A finally block is always executed even when the program
		    // throws an exception and terminates
		    finally {
		        System.out.println ("In Finally Block: Count = "+oneCounter.getCount());
		    }
		    System.out.println ("After Finally Block: Done");
		}
}
public class ExceptionsDemo {

	
	public static void main(String[] args) {

			Counter1.test1();
	Counter1.test2();

	}

}

