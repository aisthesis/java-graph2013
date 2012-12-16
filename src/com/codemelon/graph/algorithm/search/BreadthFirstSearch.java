package com.codemelon.graph.algorithm.search;

import java.util.LinkedList;
import java.util.Set;

import com.codemelon.graph.common.Color;
import com.codemelon.graph.graph.AbstractGraph;
import com.codemelon.graph.vertex.ChildVertex;
import com.codemelon.graph.vertex.ColoredVertex;
import com.codemelon.graph.vertex.DistanceVertex;
import com.codemelon.graph.vertex.Vertex;
import com.codemelon.graph.vertex.BfsVertex;
import com.codemelon.graph.graph.VertexResetter;

/**
 * Implementation of breadth-first search following 
 * <a href="http://mitpress.mit.edu/algorithms/">CLRS</a>, pp. 594ff.
 * The graph to be searched may be directed or undirected.
 * @author Marshall Farrier
 * @my.created Dec 16, 2012
 * @my.edited Dec 16, 2012
 */
public class BreadthFirstSearch<T extends BfsVertex> {
	private AbstractGraph<T> graph;
	private T source;
	
	/**
	 * Prepares the search on the given graph
	 * @param graph graph that will be searched
	 */
	public BreadthFirstSearch(AbstractGraph<T> graph) {
		this.graph = graph;
		source = null;
	}
	/**
	 * Executes the search on the input graph. Sets the parent of the source
	 * vertex to null and sets parents for all vertices reachable from source
	 * according to a shortest path from source to the given vertex. Unreachable
	 * vertices will have parent set to null after this method call. Reachable
	 * vertices will further have distances entered according to the minimum number of 
	 * steps (edges) required to reach them from source. The source vertex will
	 * show a distance of 0, and unreachable vertices will have distances set to -1
	 * @param source source vertex from which shortest paths are to be determined
	 */
	public void search(T source) {
		if (!graph.containsVertex(source)) {
			throw new IllegalArgumentException("Invalid vertex!");
		}
		this.source = source;
		VertexResetter.resetForBfs(graph);
		LinkedList<BfsVertex> queue = new LinkedList<BfsVertex>();
		source.setColor(Color.GRAY);
		source.setDistance(0);
		queue.add(source);
		BfsVertex u;
		Set<? extends Vertex> adjacentVertices;
		while (!queue.isEmpty()) {
			u = queue.removeFirst();
			adjacentVertices = u.getAdjacencies();
			for (Vertex v : adjacentVertices) {
				if (((ColoredVertex) v).getColor() == Color.WHITE) {
					((ColoredVertex) v).setColor(Color.GRAY);
					((DistanceVertex) v).setDistance(u.getDistance() + 1);
					((ChildVertex) v).setParent(u);
					queue.addLast(((BfsVertex) v));
				}
			}
			u.setColor(Color.BLACK);
		}
	}
	/**
	 * Returns the source vertex specified when search() was called.
	 * @return the source vertex specified when search() was called
	 */
	public T getSourceVertex() { return source; }
	
	/**
	 * Shows a shortest path from the source vertex passed in the search() method
	 * to any given vertex in the graph.
	 * For actually getting the list rather than just printing, a loop seems easier
	 * than the recursion used by CLRS (p. 601)
	 * @param target the vertex to which the path is returned
	 * @return the shortest path from the source vertex passed in a prior call of search()
	 * to the target vertex. Returns null if the target is not reachable from the
	 * source vertex.
	 * @throws IllegalStateException if search() has not yet been called
	 */
	public LinkedList<BfsVertex> path(BfsVertex target) {
		if (source == null) {
			throw new IllegalStateException("Source vertex has not been specified by calling search()!");
		}
		if (target.getParent() == null && target != source) { return null; }
		LinkedList<BfsVertex> result = new LinkedList<BfsVertex>();
		BfsVertex tmp = target;
		while (tmp != source) {
			result.addFirst(tmp);
			tmp = (BfsVertex) tmp.getParent();
		}
		result.addFirst(source);
		return result;
	}
}
