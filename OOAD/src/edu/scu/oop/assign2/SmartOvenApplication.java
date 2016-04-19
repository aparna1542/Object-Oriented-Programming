package edu.scu.oop.assign2;
/**
 * 
 * @author Aparna
 * @date 01/31/15
 * @course_number COEN 275
 * @assignment_No 2
 *
 */
public class SmartOvenApplication {

	public static void main(String[] args) {
		/**
		 * case 1 Tests Oven status when 
		 * Temperature is set
		 * CookingTime is set
		 */
		Alpha1Oven oven1= new Alpha1Oven();
		oven1.setTemperature(200);
		oven1.setTime(10);
		oven1.start();
		oven1.showOvenStatus();
		System.out.println("------------------------------------------");
		/**
		 * case 2 Tests Oven status when 
		 * Temperature is  not set
		 * CookingTime is set
		 */
		Alpha1Oven oven2= new Alpha1Oven();

		oven2.setTime(10);
		oven2.start();
		oven2.showOvenStatus();
		System.out.println("------------------------------------------");

		/**
		 * case 3 Tests Oven status when 
		 * Temperature is   set
		 * CookingTime is not set
		 */
		Alpha1Oven oven3= new Alpha1Oven();

		oven3.setTemperature(200);
		oven3.start();
		oven3.showOvenStatus();
		System.out.println("------------------------------------------");
		/**
		 * case 4 Tests Oven status for Alpha2Oven when 
		 * Temperature is   set
		 * CookingTime is set
		 * ItemPlaced is placed
		 */
		Alpha2Oven oven4= new Alpha2Oven();
System.out.println("Testing oven 4");
		//oven4.setTemperature(200);
		oven4.setTemperatureInC(30);
		oven4.thermostat.getTemperatureInC();
		oven4.setTime(10);
		oven4.placeFood();
		oven4.start();
		oven4.showOvenStatus();
		System.out.println("------------------------------------------");
		/**
		 * case 5 Tests Oven status for Alpha2Oven when 
		 * Temperature is   set
		 * CookingTime is set
		 * ItemPlaced is not placed 
		 */
		Alpha2Oven oven5= new Alpha2Oven();

		oven5.setTemperature(200);
		oven5.setTime(10);
		oven5.setCookingMode(CookingMode.BROIL);
		oven5.start();
		oven5.showOvenStatus();
		System.out.println("------------------------------------------");
		/**
		 * case 6 Tests Oven status for Alpha2Oven when 
		 * Temperature is not set
		 * CookingTime is set
		 * ItemPlaced is placed 
		 */
		Alpha2Oven oven6= new Alpha2Oven();

		oven6.setTime(10);
		oven6.placeFood();
		oven6.start();
		oven6.showOvenStatus();
		System.out.println("------------------------------------------");
		/**
		 * case 7 Tests Oven status for Alpha2Oven when 
		 * Temperature is  set
		 * CookingTime is not set
		 * ItemPlaced is placed 
		 */
		Alpha2Oven oven7= new Alpha2Oven();

		oven7.setTemperature(45);
		oven7.placeFood();
		oven7.start();
		oven7.showOvenStatus();
		System.out.println("------------------------------------------");
		
		
		Alpha2Oven oven8= new Alpha2Oven();

		oven8.setTemperature(45);
		oven8.setTime(30);
		oven8.placeFood();
		oven8.start();
		oven8.showOvenStatus();
		System.out.println("------------------------------------------");
	}
	
}
