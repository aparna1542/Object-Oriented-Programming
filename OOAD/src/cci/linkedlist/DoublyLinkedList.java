/**
 * 
 */
package cci.linkedlist;

/**
 * @author Aparna Ganesh
 *
 */
public class DoublyLinkedList<T> {
	Node<T> head;
	Node<T> tail;
	int size;

	private class Node<T> {
		Node<T> prev;
		Node<T> next;
		T data;

		public Node(T data) {
			this.data = data;
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void addFirst(T data) {
		Node<T> tmp = new Node(data);
		tmp.next = head;
		tmp.prev = null;
		if (head != null) {
			head.prev = tmp;
		}
		head = tmp; // new node is the head now
		if (tail == null) { //this means the fisrt and last node are the same
			tail = tmp;
		}
		size++;
		System.out.println("Adding" + data);
	}

	public void addLast(T data) {
		Node<T> tmp = new Node(data);
		tmp.next = null;
		tmp.prev = tail;
		if (tail != null) {
			tail.next = tmp; // making tail.next point to tmp, similarly tmp = tail.next implies making tmp
								// point to whichever tail.next is pointing to
		}
		tail = tmp; // now move the tail to tmp
		if (head == null) {
			head = tmp;
		}
		size++;
		System.out.println("Adding" + data);
	}

	public T removeFirst() {
		if (isEmpty()) {
			throw new EmptyListException("Cannot remove");
		}
		Node tmp = head;
		head.prev = null;
		head = head.next; // making head point to next node
		size--;
		System.out.println("removed ele " + tmp.data);
		return (T) tmp.data;
	}

	public T removeLast() {
		if (isEmpty()) {
			throw new EmptyListException("Cannot remove");
		}
		Node tmp = tail;
		tail.next = null;
		tail = tail.prev; //shifting tail to prev node
		size--;
		System.out.println("removed ele " + tmp.data);
		return (T) tmp.data;
	}

	public void iterateForward() {
		System.out.println("iterating forward..");
		Node tmp = head; // assigning to tmp coz cant move the head
		while (tmp != null) {
			System.out.println(tmp.data);
			tmp = tmp.next; // /making tmp point to next ele
		}
	}

	public void iterateBackward() {
		System.out.println("iterating backward..");
		Node tmp = tail;
		while (tmp != null) {
			System.out.println(tmp.data);
			tmp = tmp.prev;
		}
	}
}
