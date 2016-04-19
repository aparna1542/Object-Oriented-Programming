package edu.scu.assign3;
/**
 * 
 * @author Aparna
 * @date 01/31/15
 * @course_number COEN 275
 * @assignment_No 2
 *
 */
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a Basic Oven
 * <p>
 * Provides options to set temperature in F, cooking time(in minutes)
 * @author Aparna
 *
 */
public class Alpha1Oven {

	/**
	 * Holds the status of the Oven
	 */
	protected Status status;

	/**
	 * Cooking temperature of the Oven
	 */
	protected int cookingTemp;

	/**
	 * Cooking time(in Minutes) 
	 */
	protected int cookingTimeInMinutes;

	/**
	 * {@link OvenThermostat} instance to regulate temperature
	 */
	protected OvenThermostat thermostat;


	/**
	 * Cooking start time 
	 */
	private long startTime;

	/**
	 * Boolean to represent if food item is placed in Oven or not
	 */
	protected boolean itemPlaced;

	public Alpha1Oven() {

		status = Status.OFF;
		itemPlaced = false;
		//Alpha1oven has Oven Thermostat - has-a relation
		thermostat=new OvenThermostat();
	}
	
	//has-a relation passing thermostat var of type OvenThermostat

	public Alpha1Oven(OvenThermostat thermostat) {

		this.thermostat = thermostat;
		status = Status.OFF;
		itemPlaced = false;
	}

	/**
	 * Turns off the oven
	 */
	public void turnoff() {

		status = Status.OFF;
	}

	/**
	 * Starts the Oven based on the settings
	 * Display warning message if cookingTemp or cookingTimeInMinutes are not set 
	 */
	public void start() {

		if(cookingTemp != 0 && cookingTimeInMinutes != 0) {
			status = Status.ON;
		}
		else {
			System.out.println("Cooking Temperature and/or Cooking Time not set !");
			cookingTimeInMinutes=0;
		}

	}
	public int getCookingTimeInMinutes() {
		return cookingTimeInMinutes;
	}

	public long getStartTime() {
		return startTime;
	}

	/**
	 * Sets the temperature in Thermostat in F
	 * @param degrees
	 */
	public void setTemperature(int degrees) {

		cookingTemp = degrees;
		thermostat.setTemperatureInF(degrees);
	}

	/**
	 * Sets the cooking time of the oven
	 * @param cookingTime
	 */
	public void setTime(int cookingTime) {

		cookingTimeInMinutes=cookingTime;
		startTime=System.currentTimeMillis();
	}

	/**
	 * Method to place the food item in the oven
	 */
	public void placeFood() {

		itemPlaced = true;
	}

	/**
	 * Resets the oven settings to default
	 */
	public void clear() {
		status = Status.OFF;
		itemPlaced = false;
		cookingTemp=0;
		startTime=0;
		cookingTimeInMinutes=0;
	}

	/**
	 * Displays the oven status
	 */
	public void showOvenStatus() {
		long stopTime=0;
		stopTime=startTime + cookingTimeInMinutes*60*1000;
		System.out.println("The oven is " + getClass().getSimpleName());
		System.out.println("the oven status is " + status);
		System.out.println("the start time is " + new SimpleDateFormat("HH:mm:ss").format(new Date(startTime)));
		System.out.println("the stop time is" + new SimpleDateFormat("HH:mm:ss").format(new Date(stopTime)));
		System.out.println("The current temperature is(F) " + thermostat.getTemperatureInF());
	}
}
