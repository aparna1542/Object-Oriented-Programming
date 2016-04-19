/**
 * 
 */
package cci.linkedlist;

/**
 * @author Aparna Ganesh
 *
 */
public class LinkedListPalindrome {

	
	private static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public boolean isPalindrome(Node head) {
		
		Node p = head;
		Node prev = new Node(p.data);
		
		while(p.next !=null) {
			Node temp = new Node(p.next.data);
			temp.next = prev; //reversing it
			prev = temp; //advancing prev
			p = p.next;
		}
		
		Node p1= head;
		Node p2 =prev;
		
		while(p1 !=null) {
			if(p1.data != p2.data) {
				return false;
			}
			p1 = p1.next;
	        p2 = p2.next;
		}
		
		return true;
	}
	
	public void printList(Node head) {
		Node temp = head;
		while(temp !=null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	public static void main(String args[]) {
		LinkedListPalindrome lp = new LinkedListPalindrome();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(1);
		System.out.println("linked list is");
		lp.printList(head);
		boolean result = lp.isPalindrome(head);
		if(result) {
			System.out.println("is a plaindrome");
		}
		else {
			System.out.println("not a palindrome");
		}
	}
}
