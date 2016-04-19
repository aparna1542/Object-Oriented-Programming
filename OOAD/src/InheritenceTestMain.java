
public class InheritenceTestMain {

	
	public static void main(String args[]) {
		
		Food food = new Food();
		Meat meat = new Meat();
		
		Food food_meat = new Meat();
		Mammal mammal = new Mammal();
		Lion lion = new Lion();
		Mammal lion_mammal = new Lion();
		//mammal = lion;
		
		mammal.eat(food);
		mammal.eat(meat);
		mammal.eat((Meat)food_meat);
		
		((Mammal)lion).eat(food);
		lion.eat(meat);
		lion.eat(food_meat);
		
		lion_mammal.eat(food);
		lion_mammal.eat(meat);
		lion_mammal.eat(food_meat);
		
	}
}

class Food{}

class Meat extends Food{
	public Meat() {
		
	}
	
}

class Mammal  {
	
	
	public void eat(Food f){
		System.out.println("Mammal::eat(Food)");
		
	}
	
	public void eat(Meat f) {
		
		System.out.println("Mammal:: eat(Meat)");
	}
	
}

class Lion extends Mammal {
	
	public void eat(Meat f) {
		System.out.println("Lion::eat(Meat)");

	}
	
	public void eat(Food f) {
		System.out.println("Lion::eat(Food)");
	}
	
	public void drink(){
		
	}
}

class Tiger extends Mammal {
	
}

