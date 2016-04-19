/**
 * 
 */
package cci.linkedlist;

/**
 * @author Aparna Ganesh
 *
 */
public class LinkedListTest {

	public static void main(String args[]) {
		CheckLoop linkedList = new CheckLoop(); 
		linkedList.appendIntoTail(new CheckLoop.Node("101"));
		//linkedList.appendIntoTail(new CheckCirular.Node("201"));
		CheckLoop.Node cycle = new CheckLoop.Node("201");
		linkedList.appendIntoTail(cycle);
		linkedList.appendIntoTail(new CheckLoop.Node("301"));
		linkedList.appendIntoTail(new CheckLoop.Node("401"));
		linkedList.appendIntoTail(cycle);
		
		
		//System.out.println("Linked List : " + linkedList);
		
		if(linkedList.isCyclic()){ 
			System.out.println("Linked List is cyclic as it contains cycles or loop"); 
			}
		else{ 
			System.out.println("LinkedList is not cyclic, no loop or cycle found"); }
		} 

	

		
	}

