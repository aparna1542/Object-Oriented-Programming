/**
 * 
 */
package cci.Trees;

/**
 * @author Aparna Ganesh
 * Node representation of a Tree
 */
public class Node<E> {
	
	public E data;
	public Node<E> left;
	public Node<E> right;
	public Node(E data) {
		
		this.data = data;
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return data+"";
	}


}
