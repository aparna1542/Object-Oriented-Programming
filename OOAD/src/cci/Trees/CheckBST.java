/**
 * 
 */
package cci.Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Aparna Ganesh
 *Check whether a given binary tree is a BST or not
 * comapre every ele with root, Integer.min and Integer.max they have to lie withing the range
 */
public class CheckBST {
	
	
	Node<Integer> root;
	
	
	public void insert(int data) {
		Node<Integer> node = new Node<Integer>(data);
		if(root == null) {
			root = node;
			return; //if root is null, create a root node, then return to the call to create another node
		}
		insertRec(root,node); //now place them in correct postion left or right based on condition
		
	}
	
//place the new nodes in correct position of left and right respectively
	public void insertRec(Node<Integer> currentRoot,Node<Integer> node) {
		
		if(node.data < currentRoot.data) {
			if(currentRoot.left ==null) {
				currentRoot.left = node;
				return;
			}
			else {
				insertRec(currentRoot.left,node);
			}
		}
		else {
			if(currentRoot.right ==null) {
				currentRoot.right = node;
				return;
			}
			else {
				insertRec(currentRoot.right, node);
			}
		}
	}
	
	//pass the root node as the starting point to the program
	public boolean checkBST(Node<Integer> node) {
		return checkBST(node,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	public boolean checkBST(Node<Integer> node,int min,int max) {
		//base case, even a non existant node is considered a BST
		if(node == null ) {
			return true;
		}
		if(node.data <= min || node.data >max) {
			System.out.println("Not a BST");
			return false;
		}
		
		if(!checkBST(node.left,min,node.data) || !checkBST(node.right,node.data,max)) {
			System.out.println("Not a BST");
			return false;
		}
		System.out.println("Is a BST");
	return true;
	}
	//printing level order using Queue
		private void printLevelOrder() {
			Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
			queue.add(root);
			queue.add(new Node<Integer>(-99));
			while(!queue.isEmpty()) {
				Node<Integer> n = queue.poll();
				if(n.data == -99) {
					System.out.println();
				}
				else {
					System.out.print(" " + n.data);
					if(n.left != null) {
						queue.add(n.left);
					}
					if(n.right != null) {
						queue.add(n.right);
					}
					queue.add(new Node<Integer>(-99));
				}

			}

		}
	public static void main(String args[]) {
		CheckBST checkBst = new CheckBST();
		checkBst.insert(10);
		checkBst.insert(4);
		checkBst.insert(12);
		checkBst.insert(14);
		checkBst.insert(1);
		checkBst.insert(16);
		checkBst.insert(8);
		checkBst.printLevelOrder();
		checkBst.checkBST(new Node<Integer>(10));
		
	}
}
