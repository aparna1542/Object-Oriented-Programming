/**
 * 
 */
package cci.stacksandqueues;

/**
 * @author Aparna Ganesh
 * Implementing Generics for Collection class Stack. Here Stack can hold any datatype
 */
public class Stack<T> {

	Node<T> head;
	
	public class Node<T> {
		T data;
		Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
		
	}
	
	public void push(T data) {
		
		Node<T> temp = head; //retaining head value in temp before pushing an item
		head = new Node<T>(data);
		head.next = temp; //moving the head to point to the current node
		
	}
	
	public T pop() {
	//TODO check if stack is empty? then we cant delete	
			T data = head.data; //retrieving the top most ele
			head = head.next; //movin the pointer
			return data;
		
	}
	
	public T peek() {
		return head.data;
	}
	
	public boolean isEmpty() {
		return head==null;
	}
	public void printStack() {
		
		Node<T> temp = head;
		
		while(temp !=null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		
	}
}
