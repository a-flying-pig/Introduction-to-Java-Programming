package chapter27_graph_and_application;

import java.util.List;

public interface Graph<V> {
	
	public int getSize();
	
	public List<V> getVertices();
	
	public V getVertex(int index);
	
	public int getIndex(V v);
	
	public List<Integer> getNeighbors (int index);
	
	public int getDegree(int v);
	
	public int[][] getAdjacencyMatrix();
	
	public void printAdjacencyMatrix();
	
	public void printEdges();
	
	/** Obtain a depth-first search tree */
	public AbstractGraph<V>.Tree dfs(int v);
	
	/** Obtain a breadth-first search tree */
	public AbstractGraph<V>.Tree bfd(int v);
	
	
}