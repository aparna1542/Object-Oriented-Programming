package cci.Graphs;

/**
 * @author Aparna Ganesh
 * Graph class holds the vertices and number of nodes that we can create for this graph
 */
public class Graph {
	
	private Node[] vertices;
	

	private int count;
	private int numberOfNodes;
	
	public Graph(int numOfNodes) {
		this.numberOfNodes = numOfNodes;
		vertices = new Node[numOfNodes];
		count = 0;
	}
	
	public void addNodes(Node n) {
		if(count < numberOfNodes) {
			vertices[count] = n;
			count++;
		}
	}
	public Node[] getVertices() {
		return vertices;
	}
}

