/**
 * 
 */
package cci.linkedlist;

/**
 * @author Aparna Ganesh
 * Finding the middle node in a SinglyLinked List
 */
public class FindMiddleNode {

	Node head;

	//finding middle element
	
	public int findMiddle() {
		
		Node curr = head;
		Node middle = head;
		int length =0;
		
		//checking whether have we reached end of list or not.. 
		//are there any other nodes to traverse
		while(curr.next !=null) {
			length++; // maintain a length var 
			if(length % 2 == 0) { //to find out if the slow ptr moves ever second node
				middle = middle.next; //moving slow ptr every other node
			}
			curr = curr.next; // fast ptr is moved every node
		}
		return (int) middle.data;
		
	}

	public static void main (String args[]) {
		FindMiddleNode mn = new FindMiddleNode();
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<>();
		
		ll.appendToTail(1);
		ll.appendToTail(2);
		ll.appendToTail(3);
		ll.appendToTail(4);
		ll.appendToTail(5);
		ll.printList();
		int result = mn.findMiddle();
		System.out.println("the middle ele is"+result);
		
	}
}
