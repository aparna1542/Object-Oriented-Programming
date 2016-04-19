/**
 * 
 */
package cci.linkedlist;

/**
 * @author Aparna Ganesh
 * Reversing a Singly Linked List
 */
public class ReverseLinkedList {

	static Node head;

	private static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public void addFirst(int data) {
		if (head == null) {
			head = new Node(data);
		}
	}

	public void appendToTail(int data) {

		if (head == null) {
			addFirst(data);
		} else {
			Node newNode = new Node(data);
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	public Node reverse(Node node) {

		Node curr = head;
		Node prev = null;
		Node next = null;

		while (curr != null) {
			next = curr.next; //step 1 assign next
			curr.next = prev; //step 2 reversing 
			prev = curr; //move the pointers forward
			curr = next;
		}
		node = prev; // finally prev is pointing to the start of the reverse list 
		return node; // so return that
	}

	public void printList() {

		Node temp = head;

		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}

	}
	public static void main(String args[]) {
		
		ReverseLinkedList rl = new ReverseLinkedList();
		rl.appendToTail(1);
		rl.appendToTail(2);
		rl.appendToTail(3);
		System.out.println("the linked list is ");
		rl.printList();
		head = rl.reverse(head);
		System.out.println("The reverse linked list is");
		rl.printList();
		
	}
	


}
