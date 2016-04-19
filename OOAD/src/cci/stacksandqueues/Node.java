/**
 * 
 */
package cci.stacksandqueues;

/**
 * @author Aparna Ganesh
 * Node representation of a Stack/Queue
 */
public class Node<T> {

	T data;
	Node<T> next;

	public Node(T data) {
		this.data = data;
	}
	
}
