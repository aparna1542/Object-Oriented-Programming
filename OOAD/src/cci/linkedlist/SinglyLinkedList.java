/**
 * 
 */
package cci.linkedlist;



/**
 * @author Aparna Ganesh
 * General rule is if we need to refer the node which head or temp or curr is not pointing to 
 * then we need one more pointer called prev to use the node which curr is not referring to
 * this comes in 'delete a node ' and 'insert before '
 */
public class SinglyLinkedList<T> {
	Node<T> head = null;

	public void addFirst(T d) {
		head = new Node(d);
	}

	public Node<T> getHead() {
		return head;
	}


	// code for inserting at the end
	public void appendToTail(T d) {
		System.out.println("Appending " + d);
		if (head == null) {
			addFirst(d);
		} else {

			Node<T> newNode = new Node<T>(d);
			Node<T> n = head; // 'n' is like temp to keep moving the pointer in the
							// list
			while (n.next != null) {
				n = n.next;
			}
			n.next = newNode;
		}
	}

	// code for insertAfter certain index
	// key = the node after which the newData has to be inserted
	public void insertAfter(T key, T newData) {
		Node<T> n = head;
		// to find where the data has to be inserted
		while (n != null && !n.data.equals(key)) {
			n = n.next;
		}

		if (n != null) {
			Node<T> newNode = new Node<T>(newData);
			newNode.next = n.next;
			n.next = newNode;
		}
	}

	// code for insertBefore, we use prev and curr since singlylinked l
	public void insertBefore(T key, T toInsert) {
		if (head == null)
			return;

		if (head.data == key) {
			addFirst(toInsert);
			return;
		}

		Node<T> prev = null;
		Node<T> cur = head;

		while (cur != null && !cur.data.equals(key)) {
			prev = cur;
			cur = cur.next;
		}
		// insert between cur and prev
		if (cur != null)
			prev.next = new Node<T>(toInsert);
		cur = cur.next;
	}

	// code to delete a node
	public void removeNode(T key) {

		if (head == null) { // implies there is no node in the list
			throw new RuntimeException("cannot delete");
		}
		if( head.data == key ) // if head is the node to delete then move the reference
		   {
		      head = head.next;
		      return;
		   }
		Node<T> prev = null;
		Node<T> curr = head;

		while (curr != null && !curr.data.equals(key)) {
			prev = curr;
			curr = curr.next;
		}

		if (curr == null) {
			throw new RuntimeException("cannot delete");
		}
		prev.next = curr.next; // shifting of references to next node so the
								// curr node gets deleted
	}

	public void printList() {
		Node<T> n = head;
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
}
