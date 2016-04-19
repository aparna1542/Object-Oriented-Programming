/**
 * 
 */
package cci.Trees;

/**
 * @author Aparna Ganesh
 *
 */
public class BinaryTree {

	Node<Integer> root;

	public void insert(int data) {
		Node<Integer> node = new Node(data);
		if (root == null) {
			root = node;
			return;
		}
		insertRec(root, node);
	}

	public Node<Integer> getRoot() {
		return root;
	}

	public boolean insertRec(Node<Integer> currRoot, Node<Integer> node) {
		
		//TODO
		return true;
			
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
		public static void main(String args[]) {
			BinaryTree bt = new BinaryTree();
			bt.insert(1);
			bt.insert(2);
			bt.insert(3);
			bt.insert(6);
			//bt.insert(7);
			bt.printLevelOrder(3);
			
		}
}
