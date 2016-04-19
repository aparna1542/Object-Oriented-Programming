/**
 * 
 */
package cci.linkedlist;

/**
 * @author Aparna Ganesh Remove duplicates from a LinkedList without using
 *         buffer
 */
public class RemoveDupLLNoBuffer {

	public static int removeDup(Node<Integer> head) {
		// runner to go till end of LL and check current with rest of ele
		Node<Integer> current = head;

		int dupElem = 0;

		if (head == null) {
			return -1;
		}

		// current keeps moving one by one
		while (current != null) {

			/* Remove all future nodes that have the same value */

			Node<Integer> runner = current; // resetting runner after every run
			while (runner.next != null) {

				if (runner.next.data == current.data) {
					dupElem = runner.next.data;
					runner.next = runner.next.next;
				} else { // just move the runner
					runner = runner.next;
				}
			}
			current = current.next; // move the current

		}
		return dupElem;
	}

	public static void main(String args[]) {
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<>();
		ll.addFirst(4);
		ll.appendToTail(5);
		ll.appendToTail(5);
		ll.appendToTail(6);
		ll.appendToTail(7);

		Node<Integer> head = ll.getHead();

		int dup = RemoveDupLLNoBuffer.removeDup(head);
		System.out.println("The duplicate element is " + dup);
	}
}
