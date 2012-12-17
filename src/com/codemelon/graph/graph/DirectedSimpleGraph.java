package com.codemelon.graph.graph;

import java.util.Collection;
import java.util.Iterator;

import com.codemelon.graph.vertex.DirectedSimpleVertex;

/**
 * @author Marshall Farrier
 * @my.created Dec 14, 2012
 * @my.edited Dec 14, 2012
 */
public class DirectedSimpleGraph<T extends DirectedSimpleVertex> extends AbstractGraph<T> {
	/**
	 * Initialize graph to a default initial capacity of 16 vertices
	 */
	public DirectedSimpleGraph() {
		super();
	}
	/**
	 * Initialize graph to have capacity for the given number of vertices
	 * @param initialCapacity expected number of vertices
	 */
	public DirectedSimpleGraph(int initialCapacity) {
		super(initialCapacity);
	}
	/**
	 * Use the vertices in a collection as the initial vertices in the graph
	 * @param vertices collection of vertices that will make up the initial vertices
	 * of the graph
	 */
	public DirectedSimpleGraph(Collection<T> vertices) {
		super(vertices);
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.graph.Graph#edgeCount()
	 */
	@Override
	public final int edgeCount() {
		int result = 0;
		Iterator<T> it = super.vertexIterator();
		while (it.hasNext()) {
			result += it.next().adjacencyCount();
		}
		return result;
	}
}
