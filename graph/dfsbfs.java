package graph;

import java.util.LinkedList;

import com.sun.media.sound.MidiUtils.TempoCache;

import graphs.Node;
import graphs.State;

public class dfsbfs extends AdjacencyList {

	public static void main(String[] args) {
		dfsbfs al = new dfsbfs();
		Graph graph = new Graph(4);
		// al.addEdge(graph, 0, 1);
		// al.addEdge(graph, 0, 4);
		// al.addEdge(graph, 1, 2);
		// al.addEdge(graph, 1, 3);
		// al.addEdge(graph, 1, 4);
		// al.addEdge(graph, 2, 3);
		// al.addEdge(graph, 3, 4);

		al.addEdge(graph, 0, 1);
		//al.addEdge(graph, 0, 2);
		//al.addEdge(graph, 2, 0);
		//al.addEdge(graph, 1, 2);
		//al.addEdge(graph, 2, 0);
		al.addEdge(graph, 1, 2);
		al.addEdge(graph, 2, 3);

		al.printGraph(graph);
		System.out.println("\nDFS Traversal\n");
		al.dfsTraversal(graph, 0);

		// make all nodes unvisited
		al.setAllUnvisited(graph);

		System.out.println("\nBFS Traversal\n");
		al.bfsTravesal(graph, 0);
		
		al.checkCyclic(graph);
	}

	public void checkCyclic(Graph g) {
		System.out.println("Cycle Detection Started..");
		
		boolean[] visited = new boolean[g.v];
		boolean[] stacked = new boolean[g.v];

		for (int i = 0; i < g.v; i++) {
			visited[i] = false;
			stacked[i] = false;
		}
		
		for(int i=0;i<g.v;i++){
			if(isCycleDetected(g,i,visited,stacked)){
				System.out.println("\nCycles detected with node"+i);
				break;			
			}
		}
	}
	
	public boolean isCycleDetected(Graph g,int vertices ,boolean[] visited, boolean[] stacked){
		System.out.println("\nisCycleDetected");
		if(visited[vertices]==false) {
			visited[vertices] = true;
			stacked[vertices] = true;
			AdjListNode tempAdj = g.array[vertices].head;			
			while(tempAdj!=null) {
				System.out.println("Adj Node "+tempAdj.dest);
				if(!visited[tempAdj.dest] && isCycleDetected(g,tempAdj.dest,visited,stacked)){
					return true;
				} else if(stacked[tempAdj.dest]) {
					return true;
				}
				tempAdj = tempAdj.next;
			}			
		}
		stacked[vertices] = false;
		return false;
	}

	public void setAllUnvisited(Graph g) {
		for (int i = 0; i < g.v; i++) {
			g.array[i].head.state = State.Unvisited;
			g.array[i].headState = State.Unvisited;
		}
		
		System.out.println("\nAll nodes marked as unvisited\n");
	}

	/* bfs traversal */
	public void dfsTraversal(Graph g, int node) {
		System.out.print(node + " ");
		g.array[node].head.state = State.Visited;
		AdjListNode algTemp = g.array[node].head;
		while (algTemp != null) {
			// algTemp.state
			if (g.array[algTemp.getData()].head.state == State.Unvisited) {
				// System.out.println(algTemp.state +" inside the block");
				dfsTraversal(g, algTemp.getData());
			}
			algTemp = algTemp.next;
		}
	}

	/* program for dfs traversal */
	public void bfsTravesal(Graph g, int node) {
		LinkedList ll = new LinkedList();
		ll.add(g.array[node]);
		// g.array[node].head.state = State.Visited;
		while (!ll.isEmpty()) {
			AdjList val = (AdjList) ll.remove();
			System.out.print(val.headVal + " ");
			g.array[val.headVal].headState = State.Visited;
			AdjListNode algTemp = g.array[val.headVal].head;
			while (algTemp != null) {
				if (g.array[algTemp.dest].headState == State.Unvisited) {
					ll.add(g.array[algTemp.dest]);
					g.array[algTemp.dest].headState = State.Visited;
				}
				algTemp = algTemp.next;
			}
		}
	}

}
