/**
 * 
 */
package cci.linkedlist;

/**
 * @author Aparna Ganesh
 *
 */
public class SinglyLinekdListTest {

	public static void main(String args[]) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.appendToTail(1);
		list.appendToTail(1);
		list.appendToTail(4);
		list.appendToTail(5);
		
		list.insertAfter(1, 2);
		list.insertBefore(4, 3);
		list.printList();
		list.removeNode(5);
		System.out.println("List after deletion");
		list.printList();
	}
}
