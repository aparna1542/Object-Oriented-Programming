/**
 * 
 */
package cci.stacksandqueues;

/**
 * @author Aparna Ganesh
 *  Here we use Stack class to hold integer values
 */
public class StackMin extends Stack<Integer> {
	
	Stack<Integer> auxStack;
	
	public StackMin() {
		auxStack = new Stack<Integer>();
	}
	
	public void push(Integer data) {
		
		if(data.intValue() <= getMin()) {
			auxStack.push(data);
		}
		super.push(data);
	}
	
	public Integer pop() {
		Integer data = super.pop();
		if(data.intValue() == getMin()) {
			auxStack.pop();
		}
		return data;
	}
	
	
	public void printAuxStack() {
		auxStack.printStack();
	}
	
	public int getMin() {

		if(auxStack.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		else
			System.out.println("Min value is "+ auxStack.peek());
		return auxStack.peek();
	}
}
