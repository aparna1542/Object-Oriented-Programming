package covar_contravar_innerClasses;

/**
 * @(#)CovarParamDemo.java
 * @author 
 * @version 1.00 
 */

class Food {
       public void nutritionalProfile() { 
       		System.out.println("Food.nutritionalProfile");
       }
}
class Plant extends Food {
      public void nutritionalProfile() { 
      		System.out.println("Plant.nutritionalProfile");
       }
 }
 class Meat extends Food {
       public void nutritionalProfile() { 
       		System.out.println("Meat.nutritionalProfile");
       }
 }
class Animall {
       void eat(Food food) {
       		System.out.println("Animal.eat - Food");
       		food.nutritionalProfile();
       	}
}
class Elephant extends Animall {
	
	
	  void eat(Food food) {
       		System.out.println("Elephant.eat - Food");
       		food.nutritionalProfile();
       	}		
	
       public void eat(Plant food) { 
       	System.out.println("Elephant.eat - Plant");
       	food.nutritionalProfile();
       }	
}
 
class Lion1 extends Animall {
     public void eat(Meat food) {  
       		System.out.println("Lion.eat - Meat");
       		food.nutritionalProfile();
     }
     
 }
public class CovarParamDemo {
        
    public static void main(String[] args) {
    	
    	// Create instances of Food
    	
    	Food food1  = new Food();
    	
    	Plant plant = new Plant();
    	
    	Meat meat = new Meat();
    	
    	Food food2 = new Plant();
    	
    	
    	// Create instances of animals
    	
        Animall animal = new Animall();
        
        Elephant elephant = new Elephant();
        
        Lion1 lion = new Lion1();
        
    //passing plant to animal.eat method which has Food reference-assigning narrow(Plant) to wider type(Food)     
        // Set 1
        animal.eat(food1);
        System.out.println("------------------");
        animal.eat(plant);
        System.out.println("------------------");
        animal.eat(meat);
        System.out.println("------------------");
        animal.eat(food2);
        
        System.out.println("====================");
        // Set 2
        elephant.eat(food1);
        System.out.println("------------------");
        elephant.eat(plant);
        System.out.println("------------------");
        elephant.eat(meat);
        System.out.println("------------------");
        elephant.eat(food2);
          
    }
}
/*
Animal.eat - Food
Food.nutritionalProfile
------------------
Animal.eat - Food
Plant.nutritionalProfile
------------------
Animal.eat - Food
Meat.nutritionalProfile
------------------
Animal.eat - Food
Plant.nutritionalProfile
====================
Elephant.eat - Food
Food.nutritionalProfile
------------------
Elephant.eat - Plant
Plant.nutritionalProfile
------------------
Elephant.eat - Food
Meat.nutritionalProfile
------------------
Elephant.eat - Food
Plant.nutritionalProfile
 */
 
 