/**
 * 
 */
package cci.linkedlist;

/**
 * @author Aparna Ganesh
 *
 */
public class SinglyLinkedListt {

	Node head;
	
	private static class Node {
		
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
		
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	//create a node and add it to the beginning of the list
	
	public void addFirst(int data) {
		
		head = new Node(data,head);
		
		//traversing the list - dont change head rather maintain seperate pointer 'n' to traverse through the list
		Node n = head;
		while(n!=null) {
			n = n.next;
		}
	}
	
	// append node to the end of the list
	
	public void addLast(int data) {
		
		if(head==null) {
			addFirst(data);
		}
		else {
			Node end = new Node(data);
			Node temp = head; // 'n' is like temp to keep moving the pointer in the list
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = end; // adding reference links bet head and new node created
		}
		
	}
	
	//find the node containing the key and insert the new node after it
	
	public void insertAfter(int key, int toInsert) {

		Node temp = head;
		
		while(temp != null && temp.data !=key) {
			temp = temp.next; //noting but advancing the pointer
		}
		if(temp.next != null) {
			Node newNode = new Node(toInsert);
			newNode.next = temp.next; //Eg insert 2 after 1.. then make 2 point to 3, then 1 point to 2
			temp.next = newNode;
		}
	}
	// insert a new node before the key
	
	public void insertBefore(int key,int toInsert) {
		
		if(head==null) {
			return; // if head is null, then it means there is no node in the list
		}
		
		if(head.data ==key) {
			addFirst(toInsert);
			return;
		}
		
		Node prev = null;
		Node curr = head;
		
		//if key is not matched(curr.data != key) and end of list(curr != null) is not reached
		while(curr !=null && curr.data != key) {
			// move curr and prev references,
			prev = curr;
			curr = curr.next;
		}
		//insert bet prev and curr
		//curr == null means that no key found and curr reached the end of list
		if(curr!=null) {
			Node newNode = new Node(toInsert);
			newNode.next = curr;
			prev.next = newNode;
		}
	}
	
	//code to delete a node
	public void removeNode(int key) {
		
		if(head == null) {
			throw new RuntimeException("cannot delete");
		}
		Node prev = null;
		Node curr = head;
		
		while(curr != null && curr.data != key) {
			prev = curr;
			curr = curr.next;
		}
		
		if(curr == null) {
			throw new RuntimeException("cannot delete");
		}
		prev.next = curr.next; // shifting of references to next node so the curr node gets deleted
	} 
	
	
	
	
	
	
	
	
}
