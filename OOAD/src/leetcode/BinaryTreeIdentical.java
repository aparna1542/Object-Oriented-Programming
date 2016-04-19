package leetcode;
import cci.Trees.BinarySearchTree;
import cci.Trees.Node;

/**
 * @author Aparna Ganesh
 * Program to check if two binary trees are identical or not, they shud be symmetric
 */
public class BinaryTreeIdentical {

	// method to check if two binary tree are identical or not
	private static boolean checkIdentical(Node<Integer> root1,Node<Integer> root2) {

		//1.both are empty
		if(root1==null && root2==null ) {
			return true;
		}
		//2.both are non-empty then compare
		if(root1 !=null && root2 !=null) {
			return (root1.data == root2.data && checkIdentical(root1.left, root2.left) && checkIdentical(root1.right, root2.right));
		}
		//3 finally return false if either one is also empty
		
			return false;
		
	}

	public static void main(String args[]) {
		BinarySearchTree bst1 = new BinarySearchTree();
		BinarySearchTree bst2 = new BinarySearchTree();
		bst1.insert(2);
		bst1.insert(1);
		bst1.insert(3);
		bst2.insert(2);
		bst2.insert(1);
		bst2.insert(3);
		Node<Integer> root1 = bst1.getRoot();
		Node<Integer> root2 = bst2.getRoot();
		boolean result = checkIdentical(root1, root2);
		if (result) {
			System.out.println("They are identical");
		} else {
			System.out.println("Not identical");
		}

	}

}
