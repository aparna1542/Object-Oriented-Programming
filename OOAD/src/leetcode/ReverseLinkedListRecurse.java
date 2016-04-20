/**
 * 
 */
package leetcode;
import cci.linkedlist.SinglyLinkedList;
import cci.linkedlist.Node;

/**
 * @author Aparna Ganesh
 * Reverse a linked list recursively
 */
public class ReverseLinkedListRecurse {
	
	public static Node<Integer> reverseList(Node<Integer> head) {
		//base case
		if(head==null || head.next ==null) {
			return head;
		}
		 //get second node    
		Node<Integer> second = head.next;
	    //set first's next to be null
	    head.next = null;
	 
	    Node<Integer> rest = reverseList(second);
	    second.next = head;
	 
	    return rest;
	}

	public static void main(String args[]) {
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<>();
		ll.appendToTail(1);
		ll.appendToTail(2);
		ll.appendToTail(3);
		System.out.println("Original list is ");
		ll.printList();
		Node<Integer> head = ll.getHead();
		Node<Integer> reverse = ReverseLinkedListRecurse.reverseList(head);
		ll.setHead(reverse);
		System.out.println("Reversed List is ");
		ll.printList();
	}
}
