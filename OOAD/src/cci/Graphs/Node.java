package cci.Graphs;
/*
 * Node representation of a Graph. Stores vertex and adjacent array because one vertex
 * can be connected to many nodes 
 */

class Node {
   
	private Node[] adjacent; //similar to left node or right node of a Tree
	private int vertex; //similar to data of Tree node
	private int count;
	int adjacentLength; //how many adj nodes it has
	public FindRoute.State state;
	
	@Override
	public String toString() {
		return "Node :"+vertex;
	}

	public Node(int vertex,int adjacentLength) {
		this.vertex = vertex;
		this.adjacentLength = adjacentLength;
		adjacent = new Node[adjacentLength];
		count = 0;
	}
	
	public void addAdjacent(Node n) {
		if(count < adjacentLength) {
			adjacent[count] = n;
			count++;
		}
		else {
			System.out.println("Cannot add more adjacent nodes");
		}
	}
	public Node[] getAdjacent() {
		return adjacent;
	}

	public int getVertex() {
		return vertex;
	}

}
