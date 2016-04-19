package inheri_composition;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *Menu.java - Maintains the foods and calories on a menu.
 *Used to illustrate the usage of class vs instance
 *data members and methods.
 *@author RM
 */
public class Menu {
	
   /**
    *Holds the number of calories allowed per day by the menu.
    */
   private static int dailyCalories = 2000;
   
   /**
    *Represents the upper limit for the number of calories allowed 
    *in any menu.
    */
   private static final int DAILY_CALORIE_LIMIT = 2500;
   
    /**
    *Represents the total Calories of an instance of this class
    */
   private int totalCalories = 0;
   
    /**
    *Holds the names of food items in the menu.
    */
   private String [] foods;
   private String menuTitle;
   private int foodItems = 0;   
   private int current = 0;


	 /**
     * Constructor that sets the menu title and
     * number of food items. Creates foods array with
     *a size equal to the number of foodItems
     * @param title - to initialize the menuTitle
     * @param foodItems - to initialize the foodItems
     */

   public Menu(String title,int foodItems) {
   		menuTitle = title;
   		this.foodItems = foodItems;   
   		foods = new String[foodItems];   		 	   					
   }
   /**
     * No arg constructor will pass 
     * a default title and 1 as no.of food items 
     * to the Menu constructor with two args.
     * @see Menu constructor with two args
     */
   public Menu() {
   		this("No menu title",1); 		 	   					
   }
   
   /**
     * Adds a food item to the array, foods and 
     *adds calories to the totalCalories.
     * @param item - food item to add
     * @param calories - calories of item
     * Class var current- acts like counter var i
     */
   
   public void addFoodItem(String item, int calories){
   		if (current < foods.length && totalCalories+calories <= dailyCalories){
   			foods[current++] = item;
   			totalCalories += calories;
   		}
   		else if(totalCalories+calories > dailyCalories)
   		{
   			System.out.println(item + "'s calorie count exceeds the limit. Item not added !" +"for " + menuTitle);
   		}
   }
   
   /**
     * Prints the menu title, items on the menu and the total calories
     * 
     */
   
   public void printMenu(){
   		
   		System.out.println("Menu "+menuTitle);
   		System.out.println("Calories for this menu are below "+Menu.dailyCalories);
   		for (int i = 0; i < current; ++i){
   			System.out.print(foods[i]+"	");
   		}
   		System.out.println();
   		
   		System.out.println("Total Calories: "+totalCalories);
   		
   }
   /**
     * A class level method - sets the dailyCalories with calories, provided 
     * the calories are lower than the DAILY_CALORIE_LIMIT
     * @param calories - calories to set dailyCalories
     */
     
   public static void setDailyCalories(int calories) {
   	if (calories < DAILY_CALORIE_LIMIT)
   		dailyCalories = calories;    	
   	}
   	/**
     * 
     * @return dailyCalories of Menu.
     */   	
   		
   public static int getDailyCalories() {return Menu.dailyCalories; }
 
 
   /**
     * Entry point to the program
     */   
 
   public static void main(String args[]) {
      
     Menu.setDailyCalories(3000);
     
    	    
     Menu m1 = new Menu("Menu_One",4);
     m1.addFoodItem("cupcake",200); 
     m1.addFoodItem("applepie",300);
     m1.addFoodItem("pasta",400); 
     m1.addFoodItem("lasagna",5000); 
     m1.printMenu(); 
     
     Menu m2 = new Menu("Menu_Two",3);
     m2.addFoodItem("Burger",400); 
     m2.addFoodItem("cookie",300);
     m2.addFoodItem("Fries",500);
     m2.addFoodItem("cherry-pie",5000);
  
     m2.printMenu();
     long startTime=System.currentTimeMillis();
     System.out.println("the start time is " + new SimpleDateFormat("HH:mm:ss").format(new Date(startTime)));
     
          
   }


}