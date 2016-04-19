package Algo.DS;

public class StackArrayImpl {

	final int MAX_VALUE = 10;
	int[] stack = new int[MAX_VALUE];
	int top = 0;

	public void push(int data) {

		if (!isFull()) {
			stack[top] = data;
			top++;
			System.out.println("Pushed " + data);
		} else {
			System.out.println("The Stack is full !");
		}

	}

	
	public int pop() {

		if (!isEmpty()) {

			int data = stack[top - 1];
			top--;
			System.out.println("Popped " + data);
			return data;
		} else {
			System.out.println("The stack is empty");
		}
		return -1;
	}

	public boolean isEmpty() {

		return top == 0;

	}

	private boolean isFull() {

		return top == MAX_VALUE;

	}

	public void printStack() {
		System.out.println("The elements are ");
		for(int i : stack) {
			System.out.print(" " +i);
		}
	}
	public static void main(String args[]) {
		StackArrayImpl s = new StackArrayImpl();
		
		for (int i = 1; i < 12; i++) {
			s.push(i);
		}
		s.printStack();
	
	}
}
