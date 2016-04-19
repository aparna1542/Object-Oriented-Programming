package edu.scu.oop.assign2;
/**
 * 
 * @author Aparna
 * @date 01/31/15
 * @course_number COEN 275
 * @assignment_No 2
 *
 */

/**
 * This class represents a smart oven that extends {@link Alpha1Oven}
 * functionality and provides options to set cooking mode and temperature(in C) 
 */
public class Alpha2Oven extends Alpha1Oven {

	/**
	 * Holds the cooking mode of the oven
	 */
	private	CookingMode currentMode;

	public Alpha2Oven() {
		super();
		currentMode = CookingMode.BAKE;
	}

	/**
	 * Sets temperature in Celcius
	 * @param degrees
	 */
	public void setTemperatureInC(int degrees)
	{
		thermostat.setTemperatureInC(degrees);
	}

	/**
	 * Sets cooking mode {@link CookingMode}
	 * @param mode
	 */
	public void setCookingMode(CookingMode mode) {
		currentMode=mode;

	}

	/**
	 * Starts the oven
	 * Displays warning message if any one of cooking temperature, cooking time and item are not set
	 */
	@Override
	public void start() {

		if(cookingTemp !=0 && cookingTimeInMinutes !=0 && itemPlaced){
			status=Status.ON;
		}
		else {
			System.out.println("Cooking Temperature and/or Cooking Time not set and/or Items not placed !");
			cookingTimeInMinutes=0;
		}
	}

	/**
	 * Displays the oven status including cooking mode and temperature in celcius
	 */
	@Override
	public void showOvenStatus() {
		super.showOvenStatus();
		System.out.println("The current Temperature(C) is " + thermostat.getTemperatureInC());
		System.out.println("The cooking mode is " + currentMode);
		System.out.println("The Item placed is " + itemPlaced);

	}
	
	public static boolean isValidRange(int temperature, char degree) {
		return OvenThermostat.isValidRange(temperature,degree);
	}


}
