/**
 * 
 */
package cci.Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Aparna Ganesh Inserting nodes,finding min and
 *         max,inorder,preorder,postorder traversal in a Binary Search Tree Also
 *         check if the tree is balanced or not
 */
public class BinarySearchTree {

	Node<Integer> root;
	

	// construct a BST
	public void insert(int data) {
		Node<Integer> node = new Node<Integer>(data);

		//creating the first ele in tree
		if (root == null) {
			root = node;
			return;
		}
		insertRec(root, node);
	}

	public Node<Integer> getRoot() {
		return root;
	}
	public void setRoot(Node<Integer> root) {
		this.root = root;
	}

	private void insertRec(Node<Integer> currRoot, Node<Integer> node) {

		//traverse LST and RST insert all nodes recursively
		System.out.println("Latest Root " + currRoot.data
				+ " Ele to be inserted " + node.data);
		//insert left else insert right
		if (node.data < currRoot.data) {
			if (currRoot.left == null) { // base case
				currRoot.left = node;
				return;
			} else {
				insertRec(currRoot.left, node);
			}
		} else {
			if (currRoot.right == null) { // base case
				currRoot.right = node;
				return;
			} else {
				insertRec(currRoot.right, node);
			}
		}
	}

	// inorder traversal- LST,Root,RST
	public void inOrderTraverse() {
		System.out.println("In Order Traversal ");
		printInOrder(root);
		System.out.println("");
	}

	public void printInOrder(Node<Integer> currRoot) {
		if (currRoot == null) {
			return;
		}
		printInOrder(currRoot.left);
		System.out.println(currRoot.data);
		printInOrder(currRoot.right);
	}

	// preorder traversal, root,LST,RST

	public void preOrderTraversal() {
		System.out.println("Pre Order Traversal ");
		printRecPreOrder(root);
		System.out.println("");
	}

	public void printRecPreOrder(Node<Integer> currRoot) {
		if (currRoot == null) {
			return;
		}
		System.out.println(currRoot.data);
		printRecPreOrder(currRoot.left); //recursive calls
		printRecPreOrder(currRoot.right);
	}

	// postorder traversal, LST,RST,root

	public void postOrderTraversal() {
		System.out.println("Post Order Traversal ");
		printRecPostOrder(root);
		System.out.println("");
	}

	public void printRecPostOrder(Node<Integer> currRoot) {
		if (currRoot == null) {
			return;
		}
		printRecPostOrder(currRoot.left);
		printRecPostOrder(currRoot.right);
		System.out.println(currRoot.data);
	}

	// printing BST
	public void printLevelOrder(int depth) {
		for (int i = 1; i <= depth; i++) {
			System.out.print("Level " + (i-1) + ": ");
			String levelNodes = printLevel(root, i);
			System.out.print(levelNodes + "\n");
		}
	}

	public String printLevel(Node<Integer> t, int level) {
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

	
	//printing level order using Queue
	public void printLevelOrder() {
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

	// finding maximum
	public int findmaximum() {
		if (root == null) {
			return 0;
		}
		Node<Integer> currentNode = root;
		while (currentNode.right != null) {
			currentNode = currentNode.right;
		}
		return currentNode.data;
	}

	// findind minimum
	public int findMinimum() {
		if (root == null) {
			return 0;
		}
		Node<Integer> currentNode = root;
		while (currentNode.left != null) {
			currentNode = currentNode.left;
		}
		return currentNode.data;
	}

	

	public static void main(String args[]) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(5);
		bst.insert(4);
		bst.insert(3);
		bst.insert(6);
		//bst.insert(5);
		//bst.insert(6);
		//bst.printLevelOrder(3);
		bst.printLevelOrder();
		int maxVal = bst.findmaximum();
		System.out.println("Max ele is " + maxVal);
		int minVal = bst.findMinimum();
		System.out.println("Min ele is " + minVal);
		bst.postOrderTraversal();
		bst.preOrderTraversal();
		bst.inOrderTraverse();
		
	}
}
