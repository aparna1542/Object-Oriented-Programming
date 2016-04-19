package covar_contravar_innerClasses;

/**
 * 
 * @(#)CovarReturnTypeDemo.java
 * @author 
 * @version 1.00 
 */

class Animal {
       void say() {
       		System.out.println("Animal.say");      		
       	}
}

class Lion extends Animal {
     void say() {
       		System.out.println("Lion.say");      		
      }    
}
class LionCub extends Lion {
     void say() {
       		System.out.println("LionCub.say");      		
      }    
}
class AnimalTamer {	
	public Animal pet() {return new Animal();}
}

class LionTamer extends AnimalTamer {
		
	public Lion pet() {return new LionCub();}
		
}

/**The return type (S2) of the method the subclass can
 * be different from the return type (S1) of the corresponding 
 * method in the superclass, provided S2 is a subtype of S1.
 *
 *Covariant return, means that when one overrides a method, the 
 *return type of the overridden method is allowed to be a subtype 
 *of the overridden method's return type.
 */

public class CovarReturnTypeDemo {
         
    public static void testCovarReturnType() {
 	
    	// Create instances of animals
    	
        AnimalTamer animal_tamer = new AnimalTamer();
        
        LionTamer lion_tamer = new LionTamer();
       
        Animal animal = animal_tamer.pet();
        
        animal.say();
        
        System.out.println("------------------");
        
        Lion lion = lion_tamer.pet();
        lion.say();
        
        animal = lion_tamer.pet();
        animal.say();
        
        System.out.println("------------------");
        
        animal_tamer = lion_tamer;
        animal = animal_tamer.pet();       
        animal.say();   	
    } 
    	   
    public static void main(String[] args) {
    	
    	testCovarReturnType();
    }
}
