/**
 * 
 */
package cci.Graphs;

import java.util.ArrayList;

import cci.stacksandqueues.Stack;

/**
 * @author Aparna Ganesh Iterative impl of DFS using stacks.
 */
public class DFSIterative {

	public static void dfsIterative(ArrayList<ArrayList<Integer>> adjList,
			int vertex) {
		boolean[] visited = new boolean[adjList.size()];
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> auxStack = new Stack<Integer>();
		stack.push(vertex);
		while (!stack.isEmpty()) {
			int v = stack.pop();
			visited[v] = true;
			System.out.print(v + " ");
			

			for (int w : adjList.get(v)) {
				if (!visited[w]) {
					auxStack.push(w);
				}
			}

			while (!auxStack.isEmpty()) {
				stack.push(auxStack.pop());
			}

		}
	}
	public static void main(String args[]) {
		// Create adjacency list representation
		ArrayList<ArrayList<Integer>> adjLists = new ArrayList<ArrayList<Integer>>();
		// Add an empty adjacency list for each vertex
		for (int v = 0; v < 7; v++) {
			adjLists.add(new ArrayList<Integer>());
		}
		// insert neighbors of vertex 0 into adjacency list for vertex 0
		//getting array list created above (total 7) one by one and adding ele to them
		adjLists.get(0).add(1);
		adjLists.get(0).add(2);
		adjLists.get(0).add(3);

		adjLists.get(1).add(5);
		adjLists.get(1).add(6);
		
        adjLists.get(2).add(4);
     
        adjLists.get(3).add(2);
        adjLists.get(3).add(4);
        
        adjLists.get(4).add(1);
 
        // insert neighbors of vertex 5 into adjacency list for vertex 5
        // -> nothing to do since vertex 5 has no neighbors
         
        // insert neighbors of vertex 6 into adjacency list for vertex 5
        adjLists.get(6).add(4);

        dfsIterative(adjLists, 0);
	}
}
