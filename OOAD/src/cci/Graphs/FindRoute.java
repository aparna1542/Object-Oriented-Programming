package cci.Graphs;

import java.util.LinkedList;

public class FindRoute {
	public enum State {
		Unvisited, Visited, Visiting;
	}

	public static boolean search(Graph g, Node start, Node end) {
		// storing all the adjacent vertices in a LL to print level by
		// level(mainly for ordering)
		LinkedList<Node> linkedListOfNodes = new LinkedList<>();
		// marking all the nodes as unvisited
		for (Node n : g.getVertices()) {
			n.state = State.Unvisited;
		}
		if (start == end) {
			System.out.println("start and end node are same!");
			return false;
		}
			// adding start node into LL
			linkedListOfNodes.add(start);
		while (!linkedListOfNodes.isEmpty()) {
			Node node = linkedListOfNodes.remove();
			if (node != null) {
				node.state = State.Visited;
				for (Node n : node.getAdjacent()) {
					if (n.state != State.Visited) { // to avoid loop else will
													// keep referring the same
													// node again
						n.state = State.Visiting;
						if (n != end) {
							// n.state = State.Visited;
							linkedListOfNodes.add(n);
						} else { // end found
							System.out.println("Path found between " + start
									+ " & " + n);
							return true;
						}
					}
				}
			}
		}
		System.out.println("No path found");
		return false;
	}

	public static void main(String args[]) {
		Graph graph = new Graph(6);
		Node[] temp = new Node[6];
		temp[0] = new Node(1, 3);
		temp[1] = new Node(2, 0);
		temp[2] = new Node(3, 0);
		temp[3] = new Node(4, 1);
		temp[4] = new Node(5, 1);
		temp[5] = new Node(6, 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);

		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		// Adding nodes to graph
		for (int i = 0; i < temp.length; i++) {
			graph.addNodes(temp[i]);
		}
		Node[] n = graph.getVertices();
		Node start = n[5];
		Node end = n[5];
		// passing the start and end ele for which the route has to be found
		search(graph, start, end);

	}

}
