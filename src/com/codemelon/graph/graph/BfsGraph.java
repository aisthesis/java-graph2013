package com.codemelon.graph.graph;

import java.util.Collection;
import java.util.Iterator;

import com.codemelon.graph.vertex.BfsVertex;
import com.codemelon.graph.vertex.UndirectedSimpleVertex;

/**
 * Undirected graph meeting the requirements for conducting breadth-first search
 * @author Marshall Farrier
 * @my.created Dec 16, 2012
 * @my.edited Dec 16, 2012
 */
public class BfsGraph<T extends UndirectedSimpleVertex & BfsVertex> extends AbstractGraph<T> {
	/**
	 * Initialize graph to a default initial capacity of 16 vertices
	 */
	public BfsGraph() {
		super();
	}
	/**
	 * Initialize graph to have capacity for the given number of vertices
	 * @param initialCapacity expected number of vertices
	 */
	public BfsGraph(int initialCapacity) {
		super(initialCapacity);
	}
	/**
	 * Use the vertices in a collection as the initial vertices in the graph
	 * @param vertices collection of vertices that will make up the initial vertices
	 * of the graph
	 */
	public BfsGraph(Collection<T> vertices) {
		super(vertices);
	}

	@Override
	public int edgeCount() {
		int result = 0;
		Iterator<T> it = super.vertexIterator();
		while (it.hasNext()) {
			result += it.next().adjacencyCount();
		}
		return result / 2;
	}
}
