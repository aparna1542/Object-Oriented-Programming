/**
 * 
 */
package cci.stacksandqueues;

/**
 * @author Aparna Ganesh
 * TowerOfHanoi problem coded by me
 */
public class Tower {

	private Stack<Integer> disks;
	int index =0;
	/**
	 * @param i
	 */
	public Tower(int i) {
		disks = new Stack<Integer>();
		index = i;
	}
	
	//method to return the position of the tower
	public int index() {
		return index;
	}
	
	public void add(int d) {
		if(!disks.isEmpty() && disks.peek() <=d) {
			System.out.println("Error placing disks");
		}
		else {
			disks.push(d);
		}
	}
	
	//pop the disk out and place it in destination tower
public void moveTop(Tower dest) {
	
	int top = disks.pop();
	dest.add(top);
	System.out.println("Moving disk"+top +"from"+index()+"to"+dest.index());
}
	public void moveDisks(int n,Tower destination,Tower buffer) {
		
		if(n>0) {
			moveDisks(n-1,buffer,destination);
			moveTop(destination);
			buffer.moveDisks(n, destination, this);
		}
	}
	public static void main(String args[]) {
		
	//num of disks
		int n = 4;
		Tower[] tower = new Tower[n];
		
		//number of tower will always be three
		for(int i=0;i<3;i++) {
			tower[i] = new Tower(i);
		}
		
		for(int i=n-1 ; i>=0; i--) {
			tower[0].add(i);
		}
		
		tower[0].moveDisks(n,tower[2],tower[1]);
	}
}
