/**
 * 
 */
package cci.linkedlist;

/**
 * @author Aparna Ganesh
 *
 */
public class TestDoublyLL {

	public static void main(String args[]) {
		DoublyLinkedList<Integer> dd = new DoublyLinkedList<>();
		dd.addFirst(1);
		dd.addFirst(2);
		dd.addFirst(3);
		dd.addFirst(4);
		dd.addFirst(5);
		dd.iterateForward();
		dd.iterateBackward();
		dd.addLast(6);
		dd.addLast(7);
		dd.addLast(8);
		dd.iterateForward();
		
	}
}
