/**
 * 
 */
package cci.stacksandqueues;

/**
 * @author Aparna Ganesh
 *
 */
public class AnimalQueue {

	private int order = 0;
	BasicQueue<Dog> dog = new BasicQueue<>();
	BasicQueue<Cat> cat = new BasicQueue<>();

	public void enqueueAny(Animal a) {

		if (a instanceof Dog) {
			dog.enqueue((Dog) a);
		} else if (a instanceof Cat) {
			cat.enqueue((Cat) a);
		}

		a.setOrder(order);
		order++;

	}

	public Animal dequeueAny() {

		
		if (dog.size() == 0) {
			return dequeueCat();
		} else if (cat.size() == 0) {
			return dequeueDog();
		}

		Dog oldDog = dog.peek();
		Cat oldtCat = cat.peek();
//returning the oldest animal comparing both queues
		if (oldDog.isOlderThan(oldtCat)) {
			return dequeueDog();
		} else if (oldtCat.isOlderThan(oldDog)) {
			return dequeueCat();
		}

		// What to return.. PEnding if user req for cat, return oldCat ,if user req dog, return oldDog
		return null;

	}

	public Dog dequeueDog() {
		return dog.dequeue();
	}

	public Cat dequeueCat() {
		return cat.dequeue();
	}
	
	public void printAnimalQueue() {
		
		System.out.println("\nAnimals in Dog queue are: ");
		dog.printQueue();
				
 		System.out.println("\nAnimals in Cat queue are: ");
 		cat.printQueue();
		
	}
	
	public static void main(String args[]) {
		AnimalQueue animal = new AnimalQueue();
		
		animal.enqueueAny(new Cat("kitty"));
		animal.enqueueAny(new Cat("mitty"));
		animal.enqueueAny(new Cat("lossy"));
		animal.enqueueAny(new Cat("cutie"));
		animal.enqueueAny(new Cat("tiny"));
		animal.enqueueAny(new Dog("ruso"));
		animal.printAnimalQueue();
		System.out.println("Dequeue Dog :" + animal.dequeueDog());
		System.out.println("Dequeue any:" + animal.dequeueAny());
		System.out.println("Dequeue Cat:" + animal.dequeueCat());
		animal.printAnimalQueue();
		
	}
}
