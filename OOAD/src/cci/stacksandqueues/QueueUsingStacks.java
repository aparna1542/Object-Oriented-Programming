/**
 * 
 */
package cci.stacksandqueues;

/**
 * @author Aparna Ganesh
 *
 */
public class QueueUsingStacks {

	Stack<Integer> stackNewest, stackOldest;

	public QueueUsingStacks() {

		stackNewest = new Stack<Integer>();
		stackOldest = new Stack<Integer>();
	}

	private void add(int data) {
		stackNewest.push(data);

	}

	private void shiftStack() {

		if (stackOldest.isEmpty()) {

			while (!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}

	}

	private int remove() {
		shiftStack(); // ensure that the stack are shifted
		int data = stackOldest.pop();
		return data;
	}

	private int peek() {
		shiftStack(); // ensure that the stack are shifted
		return stackOldest.peek();
	}

	private void printStacks() {
		System.out.println("Elem in StackNewest are ");
		stackNewest.printStack();
		System.out.println("Elem in StackOldest are ");
		stackOldest.printStack();

	}

	public static void main(String args[]) {
		QueueUsingStacks qs = new QueueUsingStacks();
		qs.add(1);
		qs.add(2);
		qs.add(3);
		qs.add(4);
		qs.add(5);
		qs.printStacks();
		System.out.println("Ele removed is " + qs.remove());
		qs.printStacks();
	}
}
