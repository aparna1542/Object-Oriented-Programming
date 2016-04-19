/**
 * 
 */
package cci.Graphs;

import java.util.ArrayList;

import cci.stacksandqueues.BasicQueue;

/**
 * @author Aparna Ganesh BFS - Adjacency List Representation
 * 
 */
public class BFSIterative {

	public static void bfsIterative(ArrayList<ArrayList<Integer>> adjList,
			int vertex) {
		boolean[] visited = new boolean[adjList.size()];
		System.out.println(" " + vertex);
		visited[vertex] = true;
		BasicQueue<Integer> queue = new BasicQueue<>();
		queue.enqueue(vertex);
		while (!queue.isEmpty()) {
			int r = queue.dequeue();
			for (int n : adjList.get(r)) {
				if (!visited[n]) {
					System.out.print(" " + n);
					visited[n] = true;
					queue.enqueue(n);
				}
			}
		}
	}
	
	public static void bfsIterativeModified(ArrayList<ArrayList<Integer>> adjList,
			int vertex) {
		boolean[] visited = new boolean[adjList.size()];
		BasicQueue<Integer> queue = new BasicQueue<>();
		queue.enqueue(vertex);
		while (!queue.isEmpty()) {
			int r = queue.dequeue();
			visit(r);
			visited[r] = true;
			for (int n : adjList.get(r)) {
				if (!visited[n]) {
					queue.enqueue(n);
				}
			}
		}
	}

	/**
	 * @param r
	 */
	private static void visit(int r) {
		System.out.print(r + " ");
		
	}

	public static void main(String args[]) {
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			adjList.add(new ArrayList<Integer>());
		}

		// insert neighbors of vertex 0 into adjacency list for vertex 0
		// getting array list created above (total 7) one by one and adding ele
		// to them
		adjList.get(0).add(1);
		adjList.get(0).add(2);

		adjList.get(1).add(3);
		adjList.get(1).add(4);
		adjList.get(1).add(0);

		adjList.get(2).add(5);
		adjList.get(2).add(6);
		adjList.get(2).add(0);

		adjList.get(3).add(1);
		adjList.get(4).add(1);
		adjList.get(5).add(2);
		adjList.get(6).add(2);

		bfsIterative(adjList, 0);
		System.out.println();
		bfsIterativeModified(adjList, 0);
	}
}
