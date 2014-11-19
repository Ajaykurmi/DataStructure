package graph;

public class AdjacencyList {
	public static void main(String[] args) {
		AdjacencyList al = new AdjacencyList();
		Graph graph = al.createGraph(5);

		al.addEdge(graph, 0, 1);
		al.addEdge(graph, 1, 2);
		al.addEdge(graph, 1, 3);
		al.addEdge(graph, 1, 4);
		al.addEdge(graph, 2, 3);
		al.addEdge(graph, 3, 4);
		al.printGraph(graph);
	}

	// Adds an edge to an undirected graph
	public void addEdge(Graph graph, int src, int dest) {
		// Add an edge from src to dest. A new node is added to the adjacency
		// list of src. The node is added at the begining
		AdjListNode newNode = new AdjListNode(dest);

		// getting last node

		if (graph.array[src].head != null) {
			AdjListNode temp = graph.array[src].head;
			while (temp.next != null) {

				temp = temp.next;
			}
			temp.next = newNode;
			//System.out.println("\nSrc "+temp.getData());
		} else {
			newNode.next = graph.array[src].head;
			graph.array[src].head = newNode;
		}

		// Since graph is undirected, add an edge from dest to src also
		newNode = new AdjListNode(src);

		if (graph.array[dest].head != null) {
			AdjListNode temp = graph.array[dest].head;
			while (temp.next != null) {

				temp = temp.next;
			}
			temp.next = newNode;
			//System.out.println("Dest "+temp.getData());
			
		} else {
			newNode.next = graph.array[dest].head;
			graph.array[dest].head = newNode;
		}
	}

	// A utility function to print the adjacenncy list representation of graph
	public void printGraph(Graph graph) {
		int vValue;
		for (vValue = 0; vValue < graph.v; ++vValue) {
			AdjListNode pCrawl = graph.array[vValue].head;
		//	System.out.println("\nAdjacency list of vertex %d\n head "
			//		+ pCrawl.getData());
			System.out.println("\nAdjacency list of vertex %d\n head " + vValue
					+ "\nDest:");
			while (pCrawl != null) {
				System.out.print(" " + pCrawl.dest);
				// printf("Dest", pCrawl.dest);
				pCrawl = pCrawl.next;
			}
			System.out.println();
		}
	}

	public Graph createGraph(int vValue) {
		Graph graph = new Graph(vValue);

		
		return graph;

	}

	public static AdjListNode newAdjListNode(int dest) {
		AdjListNode newNode = new AdjListNode(dest);

		return newNode;
	}

	
}
