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
	public Node<T> next;
	
	public Node() {
		
	}
	public Node(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return data+"";
	}

}
