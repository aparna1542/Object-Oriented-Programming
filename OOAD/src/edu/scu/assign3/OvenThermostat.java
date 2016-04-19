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
 * Represents the thermostat in an Oven
 * Implements {@link TempRegulator} interface
 */
public class OvenThermostat implements TempRegulator {

	/**
	 * Holds the current temperature of Oven
	 */
	private int currentTemperature;
	
	public static final double LOW = 30;
	
	public static final double HIGH = 110;  

	
	@Override
	public void setTemperatureInF(int degreesF)
	{
		currentTemperature=degreesF;
	}
	@Override
	public void setTemperatureInC(int degreesC)
	{
		currentTemperature=celciusToFahrenheit(degreesC);
	}
	
	@Override
	public int getTemperatureInF() {
		
		return currentTemperature;
	}
	
	@Override
	public int getTemperatureInC() {
		
		return fahrenheitToCelcius(currentTemperature);
		
	} 
	
	/**
	 * Utility method to convert Fahrenheit to Celcius
	 * @param fahrenheit
	 * @return celcius
	 */
	public static int fahrenheitToCelcius(int fahrenheit) {

		return (int) ((fahrenheit - 32)* 5.0/9.0);
	}
	
	/**
	 * Utility method to convert celcius to fahrenheit
	 * @param celcius
	 * @return temperature in fahrenheit
	 */
	public static int celciusToFahrenheit(int celcius) {

		return (int) ((9.0/5.0 * celcius ) + 32);
	}
	
	/**
	 * Utility method to validate if the given temperature is in valid range
	 * @param temperature
	 * @param unit
	 * @return true if temperature is valid, false otherwise
	 */
	public static boolean isValidRange(int temperature, char degree) {

		if(degree == 'C') {
			temperature = celciusToFahrenheit(temperature);
		}
		return (temperature >=LOW && temperature <=HIGH);	
	}
}

enum UnitType
{
	F, 
	C  

}
