
package com.scu.assign1;

import java.util.Date;

/**
 * 
 * @author Aparna,W1123723,COEN 279
 *
 */

public class Thermostat {


	private double currentTemperature;
	private Date date; 
	private UnitType unitType;
	public static final double LOW = 30.0;
	public static final double DEFAULT = 30.0;
	public static final double HIGH = 110.0;  


	public Thermostat() {
		currentTemperature = DEFAULT;
		unitType = UnitType.F;
		date = new Date();

	}


	public Thermostat(double currentTemperature) {
		if(validateRange(currentTemperature,UnitType.F)) {

			this.currentTemperature = currentTemperature;
			unitType = UnitType.F;
		}
		else {
			currentTemperature = DEFAULT;
			unitType = UnitType.F;
			System.out.println("Setting temperature to Default ("+DEFAULT+"F) since not in valid range("+LOW+"F - "+HIGH+"F)");
		}
		date = new Date();
	}


	public Thermostat(double currentTemperature, UnitType unit) {
		if(validateRange(currentTemperature,unit)) {
			this.currentTemperature = currentTemperature;
			unitType = unit;
		}
		else {
			this.currentTemperature = DEFAULT;
			unitType = UnitType.F;
			System.out.println("Setting temperature to Default ("+DEFAULT+"F) since not in valid range("+LOW+"F - "+HIGH+"F)");
		}

		date = new Date();
	}

	public void setTemperature(double temperature, UnitType unit) {

		//validate range. If invalid set it to default value.
		if(validateRange(temperature,unit)) {
			currentTemperature = temperature;
			unitType = unit;
		}
		else {
			System.out.println("Cannot set the temperature since it violates valid range("+LOW+"F - "+HIGH+"F)");
		}
	}

	public void displayFahrenheit() {

		double temperature=currentTemperature;

		if(unitType.equals(UnitType.C)) {

			temperature = celciusToFahrenheit(currentTemperature);

		}

		System.out.println("Temperature on " + date + " is " + temperature + "F");

	}




	public void displayCelsius() {

		double temperature=currentTemperature;

		if(unitType.equals(UnitType.F)) {

			temperature = FahrenheitToCelcius(currentTemperature);

		}

		System.out.println("Temperature on " + date + " is " + temperature + "C");
	}

	public void displayTemperature() {

		displayFahrenheit();
		displayCelsius();

	}

	/**
	 * Decrements the temperature by 1 unit(if the result is in valid range) 
	 * 
	 */
	public void reduce() {
		double temperature = currentTemperature - 1;
		if(validateRange(temperature,unitType)) {
			setTemperature(temperature, unitType);
		}
		else {
			System.out.println("Cannot reduce the temperature since it violates valid range("+LOW+"F - "+HIGH+"F)");
		}

	}

	/**
	 * Increments the temperature by 1 unit(if the result is in valid range)
	 */
	public void increase() {
		double temperature = currentTemperature + 1;
		if(validateRange(temperature,unitType)) {
			setTemperature(temperature, unitType);
		}
		else {
			System.out.println("Cannot increase the temperature since it violates valid range("+LOW+"F - "+HIGH+"F)");
		}

	}

	/**
	 * Prints the current date/time
	 */
	public void clock()
	{
		System.out.println("The current date is "+new Date());
	}

	/**
	 * Utility method to convert celcius to fahrenheit
	 * @param celcius
	 * @return fahrenheit
	 */
	private static double celciusToFahrenheit(double celcius) {

		return (9.0/5.0)*celcius + 32;
	}

	/**
	 * Utility method to convert Fahrenheit to Celcius
	 * @param fahrenheit
	 * @return celcius
	 */
	private static double FahrenheitToCelcius(double fahrenheit) {

		return (fahrenheit - 32)* 5/9;
	}


	/**
	 * Utility method to validate if the given temperature is in valid range
	 * @param temperature
	 * @param unit
	 * @return true if temperature is valid, false otherwise
	 */
	private static boolean validateRange(double temperature, UnitType unit) {

		if(UnitType.C.equals(unit)) {
			temperature = celciusToFahrenheit(temperature);
		}
		return (temperature >=LOW && temperature <=HIGH);	
	}



	public double getCurrentTemperature() {
		return currentTemperature;
	}


	public UnitType getUnitType() {
		return unitType;
	}

}

enum UnitType
{
	F, 
	C  

}
