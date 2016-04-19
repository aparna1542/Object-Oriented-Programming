/**
 * 
 */
package cci.Graphs;

import java.util.ArrayList;

/**
 * @author Aparna Ganesh 
 * Depth First Search. 
 * The basic algo: 1. Visit every adjacent node starting from sourceVertex and mark them true 
 * 2. If not visited then recursively search for the adjacent vertices and do the above 
 *         
 */
public class DFSRecursive {

	
	public static void dfsRecursive(ArrayList<ArrayList<Integer>> adjLists,boolean[] visited,
			int vertex) {
		
		visited[vertex] = true;							// vertices visited
		System.out.print(vertex + " ");
		for (int w : adjLists.get(vertex)) {
			if (!visited[w]) {				//if not visited then recursively search
				dfsRecursive(adjLists,visited, w);
			}
		}
	}

	public static void dfs(ArrayList<ArrayList<Integer>> adjLists,int sourceNode) {
		boolean[] visited = new boolean[adjLists.size()]; // keep a boolean array to track
		dfsRecursive(adjLists,visited,sourceNode);
		
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
System.out.println("the vertices visited are ");
        dfs(adjLists, 0);
	}

}
