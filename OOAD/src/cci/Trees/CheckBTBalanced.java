/**
 * 
 */
package cci.Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Aparna Ganesh Program to check if the binary tree is balanced or not.
 *         Idea is the recursively find the height of LST ,RST and for the
 *         node,if the diff is more than 1 then not a balanced BT. Note :
 *         Instead of Constructing BT we are doing a BST.
 */
public class CheckBTBalanced {
	

	public boolean checkBalanced(Node<Integer> root) {

		if (checkHeight(root) == -1) {
			return false;
		}
			return true;
	}
	
			
	public int checkHeight(Node<Integer> root) {
		if (root == null) {
			return 0; // base case , the tree is balanced
		}

		int leftHeight = checkHeight(root.left);
		if (leftHeight == -1) {
			return -1; // not balanced
		}
		int rightHeight = checkHeight(root.right);
		if (rightHeight == -1) {
			return -1; // not balanced
		}

		// check height for the current node
		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1) {
			System.out.println("Node ="+root.data + " leftHeight =" +leftHeight + " rightHeight = "+rightHeight);
			return -1;
		} else {
			
			
			return Math.max(leftHeight, rightHeight)+1;
		}
	}
	
	public static void main(String args[]) {
		CheckBTBalanced cbl = new CheckBTBalanced();
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(5);
		bst.insert(10);
		bst.insert(4);
		bst.insert(2);
		bst.printLevelOrder();
		Node<Integer> root = bst.getRoot();
		if(cbl.checkBalanced(root)) {
			System.out.println("The given tree is balanced");
		}
		else {
			System.out.println("Not balanced");
		}
		int height = cbl.checkHeight(root);
		System.out.println("Height of the tree is "+height);
	}
}
