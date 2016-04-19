/**
 * 
 */
package leetcode;
import cci.Trees.BinarySearchTree;
import cci.Trees.Node;

/**
 * @author Aparna Ganesh
 *
 */
public class BuildBTUsingTraversal {
	
	public Node<Integer> buildBT(int[] inOrder,int[] postOrder) {
		
		int inStart = 0;
		int inEnd = inOrder.length-1;
		int postStart = 0;
		int postEnd = postOrder.length-1;
		return buildTree(inOrder,inStart,inEnd,postOrder,postStart,postEnd);
	}

	private Node<Integer> buildTree(int[] inOrder, int inStart, int inEnd,
			int[] postOrder, int postStart, int postEnd) {
		//base case
		if(inStart > inEnd || postStart > postEnd) {
			return null;
		}
		int rootVal = postOrder[postEnd];
		Node<Integer> root = new Node<Integer>(rootVal);
		//System.out.println("root "+root.toString());
		int k=0;
		for(int i=0;i<inOrder.length;i++) {
			if(inOrder[i]==rootVal) {
				k=i;
				break;
			}
		}
		//build the left sub tree
		root.left = buildTree(inOrder, inStart, k-1, postOrder, postStart, postStart + k - (inStart + 1));
		//System.out.println("left child "+root.left.toString());
		//build the right sub tree
		root.right = buildTree(inOrder, k+1, inEnd, postOrder, postStart + k- inStart, postEnd -1);
		//System.out.println("left child "+root.left.toString());
		return root;
	}

	public static void main(String args[]) {
		BuildBTUsingTraversal bt = new BuildBTUsingTraversal();
		BinarySearchTree bst = new BinarySearchTree();
		int[] inOrder = {4,2,5,1,6,7,3,8};
		int[] postOrder = {4,5,2,6,7,8,3,1};
		Node<Integer> binaryTree = bt.buildBT(inOrder, postOrder);
		//System.out.println("binary tree "+binaryTree.toString());
		//bst.printLevel(binaryTree, 5);
		bst.setRoot(binaryTree);
		bst.printLevelOrder();
		
	}
}
