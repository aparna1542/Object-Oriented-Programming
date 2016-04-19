/**
 * 
 */
package cci.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Aparna Ganesh Checks whether a given BST has paths that sums up to a
 *         given value. Starts from Root and goes till leaf. Prints single and
 *         multiple paths also
 */
public class CheckSumBST {
	LinkedList<Integer> list;

	public CheckSumBST() {
		list = new LinkedList<Integer>();
	}

	public boolean checkSum(Node<Integer> root, int sum,
			LinkedList<Integer> list) {

		// base case
		if (root == null) {
			if (sum == 0) {
				System.out.println("Sum found for path :");
				printList(list);
				return true;
			} else {
				return false;
			}

		}
		list.add(root.data); // Add this node to the path list(tracking that ele
								// also)
		int newSum = sum - root.data;

		// If there are nodes with negative data, Eg: For sum=5, 2,3,-4,-2,-6 is
		// also a path
		// as well as 2,3, So even if the sum s 0, need to proceed
		if (newSum == 0) {
			System.out.println("Sum found for path :");
			printList(list);
		}

		if (checkSum(root.left, newSum, list)
				|| checkSum(root.right, newSum, list)) {
			return true;
		}

		// If it reaches here it means that there is no sum path for this node.
		// Hence remove the node
		System.out.println("Removing node:" + list.removeLast());

		return false;
	}

	private void printList(List<Integer> list) {

		for (int i : list) {
			System.out.print(i + " ");
		}
	}

	public static void main(String args[]) {

		CheckSumBST cbst = new CheckSumBST();
		// int arr[] = {-4,-2,2,3,6};
		// Node<Integer> root = BSTMinHeight.createMinBST(arr, 0, arr.length -
		// 1);
		// BSTMinHeight.printLevelOrder(3, root);
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(8);
		bst.insert(2);
		bst.insert(-2);
		bst.printLevelOrder(4);
		Node<Integer> root = bst.getRoot();
		if (cbst.checkSum(root, 5, cbst.list)) {
			System.out.println("Matching path found for the given sum! ");
		} else {
			System.out.println("No mathcing path found!");
		}

	}

}
