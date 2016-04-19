/**
 * 
 */
package cci.linkedlist;

import java.util.HashSet;
import java.util.Hashtable;

/**
 * @author Aparna Ganesh
 * Remove duplicated from an unsorted Linked List
 */
public class RemoveDupsLL {

	public static void removeDups(Node<Integer> n) {
		HashSet<Integer> hashSet = new HashSet<>();
		Node temp = null; //need temp to hold the the previous ele reference
		while(n != null) {

			//if the HashSet already has data, then remove the ref of that node,which is the duplicate node
			if(hashSet.contains(n.data)) { 
				temp.next = n.next;
			}
			else {
				hashSet.add(n.data);
				temp = n; //make temp and n point to same node
			}
			n = n.next;
		}
	}
	
	public static void main(String args[]) {
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<>();
		
		ll.addFirst(4);
		ll.appendToTail(2);
		ll.appendToTail(2);
		ll.appendToTail(3);
		Node<Integer> node = ll.getHead();
		System.out.println("List before removing dups");
		ll.printList();
		System.out.println("List after removing dups");
		RemoveDupsLL.removeDups(node);
		ll.printList();
		
	}
}
