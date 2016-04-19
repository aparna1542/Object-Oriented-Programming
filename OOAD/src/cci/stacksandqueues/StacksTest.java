/**
 * 
 */
package cci.stacksandqueues;

/**
 * @author Aparna Ganesh
 *
 */
public class StacksTest {

	public static void main(String args[]) {
		
//		StackPrimary stack = new StackPrimary();
//		stack.push(3);
//		stack.push(4);
//		stack.push(5);
//		stack.push(6);
//		stack.push(7);
//		stack.printStack();
//		stack.pop();
//		stack.printStack();
		
		StackMin stackMin = new StackMin();
		stackMin.push(1);
		stackMin.push(2);
		stackMin.push(3);
		stackMin.push(4);
		stackMin.push(5);
		stackMin.printStack();
		stackMin.printAuxStack();
		stackMin.getMin();
		
		
	}
}
