/**
 * 
 */
package leetcode;

/**
 * @author Aparna Ganesh
 * Node class for doubly linked list
 */
public class Node<T> {
	T data;
	Node<T> prev;
	Node<T> next;
	T key; //to track for which key are we creating a node
	
	public Node(T data1,T key) {
		this.data = data1;
		this.key = key;
	}

	
}
