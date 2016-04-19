package edu.scu.assign3;

/**
 * 
 * @author Aparna
 * @date 01/31/15
 * @course_number COEN 275
 * @assignment_No 2
 *
 */


/**
 * Interface that represents Temperature Regulator
 * <p>
 * Any class that intends to provide temperature regulator functionality
 * must implement this interface
  */
public interface TempRegulator {

	/**
	 * Sets the temperature in fahrenheit
	 * @param temp temperature in fahrenheit
	 */
	public void setTemperatureInF(int temp);
	
	/**
	 * Sets the temperature in Celcius
	 * @param temp temperature in fahrenheit
	 */
	public void setTemperatureInC(int temp);
	
	/**
	 * Returns the temperature in fahrenheit
	 * @return temperature in F
	 */
	public int getTemperatureInF();
	
	/**
	 * Returns the temperature in Celcius
	 * @return temperature in C
	 */
	public int getTemperatureInC();


}
