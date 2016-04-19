/**
 * 
 */
package cci.stacksandqueues;

/**
 * @author Aparna Ganesh
 * Animal Shelter problem using Queue
 *
 */
public abstract class Animal {

	protected int order;
	protected String name;
	
	@Override
	public String toString() {
		return name;
	}
	
	public Animal() {
		
	}
	public Animal(String name) {
		this.name = name;
	}
	
	
	public boolean isOlderThan(Animal a) {
		return this.order < a.getOrder();
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	
}
