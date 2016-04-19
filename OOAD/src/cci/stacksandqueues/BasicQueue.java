/**
 * 
 */
package cci.stacksandqueues;

/**
 * @author Aparna Ganesh A class to implement Queue data structure with
 *         enqueue(),dequeue()
 */
public class BasicQueue<T> {

	Node<T> head, last;

	public boolean isEmpty() {
		return head == null;
	}

	public void enqueue(T data) {

	Node<T> temp = last;
	last = new Node<T>(data); //after this step the prev last is lost.so storing in temp first
	
	last.next = null;

//at the very beginning head will be null , so after adding first node,make head and last point
		//to same node
		if (isEmpty()) {
			head = last;
		} 
		//if the queue has ele already,and we are adding a new node, then keep moving last
		else {
			temp.next = last;
		}

	}

	public T peek(){
		return head.data;
	}
	
	 public int size() {
	        int count = 0;
	        for (Node node = head; node != null; node = node.next) {
	            count++;
	        }
	        return count;
	    }
	 
	 //always remember to remove ele from front of the queue. FIFO
	public T dequeue() {

		T data = head.data;
		head = head.next;

		if (isEmpty()) {
			last = null;
		}


		return data;
	}

	public void printQueue() {

		Node<T> temp = head;
		
		while (temp != null) {
			T item =  temp.data;
			System.out.print("\t" + item);
			temp = temp.next;
		}
		
	}
	
	
	public static void main(String args[]) {
		BasicQueue<String> queue = new BasicQueue<>();
		System.out.println("The Queue elements are ");
		queue.enqueue("aparna");
		queue.enqueue("ff");
		queue.enqueue("muls");
		queue.enqueue("sujju");
queue.printQueue();		

	}

	
}
