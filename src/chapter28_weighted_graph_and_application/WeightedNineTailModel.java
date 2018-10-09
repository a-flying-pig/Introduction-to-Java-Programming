package chapter28_weighted_graph_and_application;

import java.util.ArrayList;
import java.util.List;

import chapter27_graph_and_application.NineTailModel;

public class WeightedNineTailModel extends NineTailModel {

	public WeightedNineTailModel() {
		List<WeightedEdge> edges = getEdges();
		
		WeightedGraph<Integer> graph = new WeightedGraph<Integer>(
				edges, NUMBER_OF_NODES);
		
		tree = graph.getShortestPatch(511);
	}
	
	private List<WeightedEdge> getEdges() {
		List<WeightedEdge> edges = new ArrayList<WeightedEdge>();
		
		for (int u = 0; u < NUMBER_OF_NODES; u++) {
			for (int k = 0; k < 9; k++) {
				char[] node = getNode(u); // Get the node for vertex u
				if (node[k] == 'H') {
					int v = getFlippedNode(node, k);
					int numberOfFlips = getNumberOfFlips(u, v);
					
					edges.add(new WeightedEdge(v, u, numberOfFlips));
				}
			}
		}
		
		return edges;
	}
	
	private static int getNumberOfFlips(int u, int v) {
		char[] node1 = getNode(u);
		char[] node2 = getNode(v);
		
		int count = 0; // Count the number of different cells
		for (int i =0; i < node1.length; i++)
			if (node1[i] != node2[i]) count++;
		
		return count;
	}
	
	public int getNumberOfFlips(int u) {
		return ((WeightedGraph.ShortestPathTree)tree).getCost(u);
	}
}
