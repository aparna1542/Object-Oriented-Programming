/**
 * 
 */
package cci.Trees;

/**
 * @author Aparna Ganesh
 * Given Tree T1 and T2, Check if T2 is subtree of T1 or not. This program uses
 *  pre-order,in-order substring approach.
 */
public class CheckSubTree {

	public  String inOrderA(Node<Integer> rootA,String i) {
		if(rootA !=null) {
			return inOrderA(rootA.left,i) + ""+rootA.data+""+inOrderA(rootA.right,i);
		}
		return "";
	}
	public  String inOrderB(Node<Integer> rootB,String i) {
		if(rootB !=null) {
			return inOrderB(rootB.left,i) + ""+rootB.data+""+inOrderB(rootB.right,i);
		}
		return "";
	}
	public  String preOrderA(Node<Integer> rootA,String i) {
		if(rootA !=null) {
			return rootA.data+""+preOrderA(rootA.left,i)+""+preOrderA(rootA.right,i);
		}
		return "";
	}
	public  String preOrderB(Node<Integer> rootB,String i) {
		if(rootB !=null) {
			return rootB.data+""+preOrderB(rootB.left,i) + ""+""+preOrderB(rootB.right,i);
		}
		return "";
	}
	
	public boolean checkSubTree(Node<Integer> rootA,Node<Integer> rootB) {
		
		String inorderA = inOrderA(rootA, "");
		String inorderB = inOrderB(rootB, "");
		String preOrderA = preOrderA(rootA, "");
		String preOrderB = preOrderA(rootB, "");
		return (inorderA.contains(inorderB)) && (preOrderA.contains(preOrderB));
				
		
	}
	public static void main(String args[]) {
		
		CheckSubTree i  = new CheckSubTree();
		BinarySearchTree bst = new BinarySearchTree();
		//Tree A
		Node<Integer> rootA = new Node<Integer>(1);
		rootA.left = new Node(2);
		rootA.right = new Node(4);
		rootA.left.left = new Node(3); 
		rootA.right.right = new Node(6);
		rootA.right.left = new Node(5); 
		//TreeB
		Node rootB = new Node(4);
		rootB.left = new Node(5);
		rootB.right = new Node(6); 
		
		bst.setRoot(rootA);
		System.out.print(" Tree A : ");
		bst.printLevelOrder(4);
		System.out.println();
		bst.setRoot(rootB);
		System.out.print(" Tree B : ");
		bst.printLevelOrder(4);
		System.out.println();
		System.out.println(i.checkSubTree(rootA,rootB));
	}
}
