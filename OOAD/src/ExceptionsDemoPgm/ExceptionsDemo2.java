/**
 * Wrapping Exceptions Demo Program
 */
package ExceptionsDemoPgm;

class MyException extends Exception {
	public MyException(String message, Throwable cause){
		super(message,cause);
	}
	public MyException(String message){
		super(message);
	}
	public String toString(){
		return super.getMessage() +" "+super.getCause().toString();
	}
}
class Counter{
	private int count = 0;
	public Counter(int count) { this.count = count;};
	// The method increment () declares that it throws an exception
	public void increment(double amount)throws IllegalArgumentException {
              if ( amount < 0){
		    throw new IllegalArgumentException("Negative amount not accepted");
              }
              count += amount;
	}
	public int getCount(){ return count;}
	
	public static void test3() throws MyException {
	    Counter oneCounter = new Counter(2);
	   
	    try {
	        oneCounter.increment (-1);
	    }	    
	    catch (IllegalArgumentException e){
              System.out.println ("test3:Catch Block: Exception wrapped");
              // Wrapping the IllegalArgumentException in a custom exception object
	          throw new MyException("MyException wrapper",e);
	    }
	    
	    finally {
	        System.out.println ("In Finally Block: Count = "+oneCounter.getCount());
	    }
	    System.out.println ("After Finally Block: Done");
	}
}
public class ExceptionsDemo2 {

public static void main(String[] args) {
	try{
		Counter.test3();
	}
	catch (MyException e){System.out.println("Main: " +e);}

}

}
/*
test3:Catch Block: Exception wrapped
In Finally Block: Count = 2
Main: MyException wrapper java.lang.IllegalArgumentException: Negative amount not accepted

*/