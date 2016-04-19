/**
 * 
 */
package cci.linkedlist;

/**
 * @author Aparna Ganesh 
 * Checks whether a given linked list forms a loop of not
 */
public class LoopOrNot {

	Node head;

	private static class Node {

		Node next;
		int data;

		public Node(int data) {
			this.data = data;
		}
	}

	public void appendToTail(int data) {

		if (head == null) {
			head = new Node(data);
		} else {
			Node temp = head; // head shud not be moved so temp
			Node newNode = new Node(data);

			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode; // make the ref point to the newNode
		}

	}
	
	public void appendToTail(Node newNode) {

		if (head == null) {
			head = newNode;
		} else {
			Node temp = head; // head shud not be moved so temp
		
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode; // make the ref point to the newNode
		}

	}

	public void printList() {

		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public boolean isLoopFormed() {

		Node fastPtr = head;
		Node slowPtr = head;

		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if (fastPtr == slowPtr) {
				return true;
			}
		}
		return false;

	}

	public static void main(String args[]) {
		LoopOrNot circular = new LoopOrNot();
		circular.appendToTail(new Node(101));
		Node startCycleNode = new Node(201);
		circular.appendToTail(startCycleNode);
		circular.appendToTail(new Node(301)); 
		circular.appendToTail(new Node(401)); 
		circular.appendToTail(startCycleNode); 
		
		//System.out.println("the linked list is ");
		//circular.printList();
		if(circular.isLoopFormed()) {
			System.out.println("the given list forms a loop");
		}
		else {
			System.out.println("No loop");
		}

	}
}
