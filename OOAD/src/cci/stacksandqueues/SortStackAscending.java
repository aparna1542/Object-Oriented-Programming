/**
 * 
 */
package cci.stacksandqueues;

/**
 * @author Aparna Ganesh
 * Sort a given Stack in ascending order using only one additional Stack
 * cannot use any other data structure to copy the elements.
 */
public class SortStackAscending extends Stack<Integer>{
	
	Stack<Integer> outputStack;
	
	public SortStackAscending() {
		 outputStack = new Stack<Integer>();
	}

	public void printSortedStack() {
		System.out.println("Sorted");
		outputStack.printStack();
	}
	public void sortStack(Stack<Integer> s) {
		
		
		while(!s.isEmpty()) {
			int temp = s.pop();
			
			while(!outputStack.isEmpty() && outputStack.peek() >temp) {
				s.push(outputStack.pop());
			}
			outputStack.push(temp);
		}
		
	}

	public static void main(String args[]) {
		SortStackAscending stack = new SortStackAscending();
		stack.push(10);
		stack.push(3);
		stack.push(11);
		stack.sortStack(stack);
		stack.printSortedStack();
		
	}
}
