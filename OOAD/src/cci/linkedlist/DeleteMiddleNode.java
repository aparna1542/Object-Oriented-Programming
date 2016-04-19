/**
 * 
 */
package cci.linkedlist;

/**
 * @author Aparna Ganesh
 * Algorithm to delete a node in the middle of a singly linked list(head is not given), given
	only access to that node.
 */
public class DeleteMiddleNode {
	
	public static void appendToTail(Node<Integer> end) {
		 
		Node<Integer> temp = end;
		 while(temp.next !=null) {
			 temp = temp.next;
		 } 
		 temp.next = end; //??
		
	}

	public static int deleteNode(Node<Integer> node) {
		
		if(node.next==null || node ==null) {
			return -1;
		}
		Node<Integer> nextNode = node.next;
		node.data = nextNode.data;
		node.next = nextNode.next;
		return node.data;
		
	}
	public static void main(String args[]) {
	
		DeleteMiddleNode.appendToTail(new Node(4));
		DeleteMiddleNode.appendToTail(new Node(5));
		Node<Integer> node = new Node(6);
		DeleteMiddleNode.appendToTail(node);
		DeleteMiddleNode.appendToTail(new Node(7));
		
		
		int delElem = DeleteMiddleNode.deleteNode(node);
		System.out.println("deleted node is " +delElem);
		
	}
}
