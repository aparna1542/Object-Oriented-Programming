/**
 * 
 */
package cci.stacksandqueues;

/**
 * @author Aparna Ganesh
 * Using Stack class created by me with push(),pop(),peek() etc..
 * Idea is Tower has Stack of disks.
 * Implementing the towers as their own object is not strictly necessary, but it does help to
	make the code cleaner in some respects. In this code, origin is this Tower object itself
 * Not using java library.
 * For the criteria that disks shud be placed in ascending order we are using LIFO concept of 
 * Stacks.
 * 
 */
public class TowerOfHanoi {

	private Stack<Integer> disks;
	private int index;

	public TowerOfHanoi(int i) {
		
		//creating a Stack to hold the disks
		disks = new Stack<Integer>();
		index = i;
	}

	public int index() {
		return index;
	}

	//adding disks to stack- push()
	public void add(int d) {
		if (!disks.isEmpty() && disks.peek() <= d) {
			System.out.println("Error placing disk " + d);
		} else {
			disks.push(d);
		}
	}

	public void moveTopTo(TowerOfHanoi t) {
		int top = disks.pop();
		t.add(top);
		System.out.println("Move disk " + top + " from " + index() + " to "
				+ t.index());
	}

	public void moveDisks(int n, TowerOfHanoi destination, TowerOfHanoi buffer) {
		
		
		if (n > 0) {
			
			//calling this method recursively
			//origin remains same here
			// move top n - 1 disks from origin to buffer, using destination as a buffer.
			moveDisks(n - 1, buffer, destination);
			
			//move top from origin to destination
			moveTopTo(destination);
			
			//calling this method recursively
			//move top n - 1 disks from buffer to destination, using origin as a buffer
			buffer.moveDisks(n - 1, destination, this);
		}
		
	}

	public static void main(String[] args) {
		
		//number of disks
		int n = 4;
		TowerOfHanoi[] towers = new TowerOfHanoi[n];
		
		
		for (int i = 0; i < 3; i++) {
			towers[i] = new TowerOfHanoi(i);
		}
		
		//adding disks to first tower
		
		for (int i = n-1; i >= 0; i--) {
			towers[0].add(i);
		}
		//towers[2]- destination, towers[1] is buffer
		towers[0].moveDisks(n, towers[2], towers[1]);
	}

}
