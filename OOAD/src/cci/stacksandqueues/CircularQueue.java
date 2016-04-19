/**
 * 
 */
package cci.stacksandqueues;

/**
 * @author Aparna Ganesh
 *
 */
public class CircularQueue<T> {
	
	private int number;
	private int front;
	private int rear;
	private int maxSize;
	private T[] circularArr;
	
	public CircularQueue(int maxSize) {
		this.maxSize = maxSize;
		circularArr = (T[]) new Object[this.maxSize];
		number =0;
		front = 0;
		rear = 0;
		
	}
	
	public boolean isFull() {
		return number == circularArr.length;
	}
	
	public boolean isEmpty() {
		return (number == 0);
	}
	
	//Add elements to Circular Queue
	public void enqueue(T item) {
		
		if(isFull()) {
			throw new QueueFullException("Queue is already full!");
		}
		else {
			circularArr[rear] = item;
			rear = (rear+1)%circularArr.length;
			number++;
		}
	}
	
	//remove ele from Circular Queue
	
	public T dequeue() {
		T item;
		if(isEmpty()) {
			throw new QueueEmptyException("Queue is empty!");
		}
		else {
			 item = circularArr[front];
			circularArr[front] = null; // since its arr, it will store the prev value, so make it null, then incr front
			front = (front+1)%circularArr.length;
			
		}
		return item;
	}
public void printQueue() {
	
	System.out.println("\nEle in queue are \n");
	for(int i=0;i<circularArr.length;i++) {
		System.out.println(circularArr[i]);
	}
}
	public static void main(String args[]) {
		CircularQueue<Integer> cirQueue =  new CircularQueue<>(5);
		cirQueue.enqueue(11);
		cirQueue.enqueue(12);
		cirQueue.enqueue(13);
		cirQueue.enqueue(14);
		cirQueue.enqueue(15);
		cirQueue.printQueue();
		System.out.println("the ele dequeued is "+cirQueue.dequeue());
		cirQueue.printQueue();
		
		
		
	}
}
