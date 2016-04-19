/**
 * 
 */
package cci.linkedlist;

/**
 * @author Aparna Ganesh
 * Node representation of a SinglyLinkedList
 */
public class Node<T> {

	T data;
	Node<T> next;
	
	public Node() {
		
	}
	public Node(T data) {
		this.data = data;
	}
}
