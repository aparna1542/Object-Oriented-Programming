/**
 * 
 */
package cci.Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Aparna Ganesh
 *  CONSTRUCT A BST WITH MIN HEIGHT,
 *  Idea is to take the mid of the given ele make it root, and recursively insert the 
 *  left and right nodes by making the mid ele root again.
 */
public class BSTMinHeight {

	public static Node<Integer> createMinBST(int arr[], int start, int end) {

		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		Node<Integer> root = new Node<Integer>(arr[mid]);
		root.left = createMinBST(arr, start, mid - 1);
		root.right = createMinBST(arr, mid + 1, end);
		return root;
	}

	// printing BST
	public static void printLevelOrder(int depth, Node<Integer> root) {
		for (int i = 1; i <= depth; i++) {
			System.out.print("Level " + (i - 1) + ": ");
			String levelNodes = printLevel(root, i);
			System.out.print(levelNodes + "\n");
		}
	}

	public static String printLevel(Node<Integer> t, int level) {
		if (t == null) {
			return "";
		}
		if (level == 1) {
			return t.data + " ";
		} else if (level > 1) {
			String leftStr = printLevel(t.left, level - 1);
			String rightStr = printLevel(t.right, level - 1);
			return leftStr + rightStr;
		} else
			// you need this to get it to compile
			return "";
	}

	public static void main(String args[]) {
		//BSTMinHeight bst = new BSTMinHeight();
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		Node<Integer> n = createMinBST(arr, 0, arr.length - 1);
		printLevelOrder(5, n);

	}
}
