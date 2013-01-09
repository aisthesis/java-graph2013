package com.codemelon.graph.graph;

import java.util.Collection;
import java.util.Iterator;

import com.codemelon.graph.vertex.DirectedEdgeDataVertex;

/**
 * Directed graph that supports edge data. The type parameter T is the type of the edge
 * data object, U provides a factory method for creating objects, and V is a vertex type
 * supporting edge data of type T.
 * @author Marshall Farrier
 * @my.created Dec 16, 2012
 * @my.edited Dec 16, 2012
 */
public class DirectedEdgeDataGraph<T, V extends DirectedEdgeDataVertex<T>> 
		extends AbstractGraph<V> {
	/**
	 * Initialize graph to a default initial capacity of 16 vertices
	 */
	public DirectedEdgeDataGraph() {
		super();
	}
	/**
	 * Initialize graph to have capacity for the given number of vertices
	 * @param initialCapacity expected number of vertices
	 */
	public DirectedEdgeDataGraph(int initialCapacity) {
		super(initialCapacity);
	}
	/**
	 * Use the vertices in a collection as the initial vertices in the graph
	 * @param vertices collection of vertices that will make up the initial vertices
	 * of the graph
	 */
	public DirectedEdgeDataGraph(Collection<V> vertices) {
		super(vertices);
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.graph.AbstractGraph#edgeCount()
	 */
	@Override
	public int edgeCount() {
		int result = 0;
		Iterator<V> it = super.vertexIterator();
		while (it.hasNext()) {
			result += it.next().adjacencyCount();
		}
		return result;
	}
}