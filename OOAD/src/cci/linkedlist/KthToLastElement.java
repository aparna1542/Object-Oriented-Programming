/**
 * 
 */
package cci.linkedlist;

import cci.linkedlist.CheckLoop.Node;

/**
 * @author Aparna Ganesh
 *
 */
public class KthToLastElement {

	public int kthToLastElement(Node head, int k) {

		if (head == null) {
			return 0;
		}
		int i = kthToLastElement(head.next(), k) + 1;
		if (i == k) {
			System.out.println(k + "th to last element is " + head.data());
		}
		return i;

	}

	public static void main(String args[]) {

		CheckLoop checkLoop = new CheckLoop();
		KthToLastElement kl = new KthToLastElement();
		Node head = new Node("2");
		checkLoop.appendIntoTail(head);
		checkLoop.appendIntoTail(new Node("4"));
		checkLoop.appendIntoTail(new Node("9"));
		checkLoop.appendIntoTail(new Node("5"));
		kl.kthToLastElement(head, 2);

	}

}
