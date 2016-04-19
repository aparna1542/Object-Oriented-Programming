package inheri_composition;

/**
 * @(#)IntefaceDemo.java
 *
 *
 * @author 
 * @version 1.00 2012/6/13
 */
interface CalorieCounter{
    // Only a method declaration, no implementation
    public double calories();

    // all data members must be public, constant and static
	public static final double ORANGE = 50;
	public static final double CUPCAKE = 300;
	public static final double ONE_APPLE = 20;
}
 class Recipe implements CalorieCounter{
    // Data Members
     int oranges = 5;
     int apples = 2;

   // Provides implementation for calories() declared in
    // interface CalorieCounter

    public double calories() {
        return oranges * ORANGE * oranges + apples * ONE_APPLE;
    }
}

class Diet implements CalorieCounter{
    	public double calories () { return 1200;}
}

public class IntefaceDemo {

    public static void main (String [] args){
        /* An interface name can be used to declare a reference variable.
        An interface reference variabe can be used to refere to any object of
        any class that implements that interface */

        CalorieCounter calCounter = new Recipe();
        System.out.println (calCounter.calories());

        calCounter = new Diet();
        System.out.println (calCounter.calories());

        /* An array of type CalorieCounter
         The array can contain references to any object of any class
         that implements CalorieCounter */

        CalorieCounter [] allDiets = new CalorieCounter [2];
        allDiets[0] = new Recipe();
        allDiets[1] = new Diet();

        for (int i = 0; i < allDiets.length; ++i)
            System.out.println (allDiets[i].calories());

    }

    
}