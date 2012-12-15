package com.codemelon.graph.graph;

import java.util.Collection;
import java.util.Iterator;

import com.codemelon.graph.vertex.UndirectedSimpleVertex;

/**
 * @author Marshall Farrier
 * @my.created Dec 14, 2012
 * @my.edited Dec 14, 2012
 */
public class UndirectedSimpleGraph extends AbstractGraph<UndirectedSimpleVertex> {
	/**
	 * Initialize graph to a default initial capacity of 16 vertices
	 */
	public UndirectedSimpleGraph() {
		super();
	}
	/**
	 * Initialize graph to have capacity for the given number of vertices
	 * @param initialCapacity expected number of vertices
	 */
	public UndirectedSimpleGraph(int initialCapacity) {
		super(initialCapacity);
	}
	/**
	 * Use the vertices in a collection as the initial vertices in the graph
	 * @param vertices collection of vertices that will make up the initial vertices
	 * of the graph
	 */
	public UndirectedSimpleGraph(Collection<UndirectedSimpleVertex> vertices) {
		super(vertices);
	}

	@Override
	public final int edgeCount() {
		int result = 0;
		Iterator<UndirectedSimpleVertex> it = super.vertexIterator();
		while (it.hasNext()) {
			result += it.next().adjacencyCount();
		}
		return result / 2;
	}
}
