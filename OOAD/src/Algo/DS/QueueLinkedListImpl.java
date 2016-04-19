package Algo.DS;

public class QueueLinkedListImpl implements Queue {
	private Node head, last;

	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Create a node to add in the end assign node oldtemp to preserve last
	 * create link bet newly added and prev ele
	 * 
	 * @param item
	 */
	public void enqueue(String item) {

		Node temp = last;
		last = new Node();
		last.data = item;
		last.next = null;

		//At the very start of the prog head will be null
		// Before adding any ele, head will be null, after adding first ele, make head and last point the same
		if (isEmpty()) {
			head = last;
		} 
		else {
			// create link for newly added ele and prev ele
			temp.next = last;
		}

		printQueue();
	}

	/**
	 * get the first item assign first to next item after removing elemets check
	 * if queue is empty
	 * 
	 * @return
	 */
	public String dequeue() {
		String item = head.data;
		head = head.next;
		//check if the queue is empty after removing the item
		if (isEmpty()) {
			last = null;
		}
		printQueue();
		return item;
	}

	// temp is to go over the ele in the list (first shud not be moved here)
	public void printQueue() {
		Node temp = head;
		if (isEmpty()) {
			System.out.println("Empty Queue");
			return;
		}
		System.out.println("The Queue elements are ");
		while (temp != null) {
			String item = temp.data;
			System.out.print("\t" + item);
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		QueueLinkedListImpl q = new QueueLinkedListImpl();
		q.enqueue("sri");
		q.enqueue("aparna");
		q.dequeue();
		q.dequeue();
		

	}
}
