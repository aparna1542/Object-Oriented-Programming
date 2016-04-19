/**
 * Custom Exceptions Demo Program
 */
package ExceptionsDemoPgm;

// Multiple catch blocks are allowed when a try block can give rise to more
// than one type of exception.
// When more than one catch block is used, the catch blcoks should be ordered
// with lowest subclass (the most specific exception) first and progressing to the
// highest (most generic) superclass.

class FishTank {
	
	double waterTemp = 70.00;
		
	public void increaseTemp(double temp)throws WaterTooHotException, Exception
	{
		if (temp <= 0){		
			throw new Exception (" temperature is not being increased");
		}
		else if (temp+waterTemp > 80.00){
	
			throw new WaterTooHotException(temp+waterTemp);
		}
		waterTemp += temp;
	}
	public double getTemp(){
		return waterTemp;
	}
	
}

//User defined exceptions
class WaterTooHotException extends Exception {
 double low = 60.00;
 double high = 80.00;
 double current;
 public WaterTooHotException () {super ("WaterTooHotException");}
 public WaterTooHotException (double temp){
     current = temp;
 }
 public String toString(){
    return("WaterTooHotException- Water Temperature in FishTank must be between "+low +" and "+high +
    	"\n current temp will be after increase will be "+current);
 }
}

public class CustomExceptionsDemo{
      
		public static void main (String [] args){
		    FishTank tank = new FishTank();
		    		   
		    try {
		        tank.increaseTemp(20);
		    }
		    // catch- block encloses the code that will handle
		    // the exception
		    catch (WaterTooHotException e){
		        System.out.println (e);
		    }
		    catch (Exception e)// 
            {
		        System.out.println (e);
		        e.printStackTrace();
		    }
		    // A finally block is always executed even when the program
		    // throws an exception and terminates

		    finally {
		        System.out.println ("Current WaterTemperature in FishTank = "+tank.getTemp());
		    }


		}
}