package com.codemelon.graph.graph;

import java.util.Collection;

import com.codemelon.graph.edge.DfsEdgeData;
import com.codemelon.graph.edge.EdgeDataFactory;
import com.codemelon.graph.vertex.DirectedDfsVertex;

/**
 * Utility class that eliminates one type parameter from DirectedEdgeDataGraph<T, U, V> by specifying V
 * as a DirectedDfsVertex<T, U>.
 * @author Marshall Farrier
 * @my.created Dec 16, 2012
 * @my.edited Dec 16, 2012
 */
public class DfsGraph<E extends DfsEdgeData, U extends EdgeDataFactory<E>> extends DirectedEdgeDataGraph<E, U, 
		DirectedDfsVertex<E, U>> {
	/**
	 * Initialize graph to a default initial capacity of 16 vertices
	 */
	public DfsGraph() {
		super();
	}
	/**
	 * Initialize graph to have capacity for the given number of vertices
	 * @param initialCapacity expected number of vertices
	 */
	public DfsGraph(int initialCapacity) {
		super(initialCapacity);
	}
	/**
	 * Use the vertices in a collection as the initial vertices in the graph
	 * @param vertices collection of vertices that will make up the initial vertices
	 * of the graph
	 */
	public DfsGraph(Collection<DirectedDfsVertex<E, U>> vertices) {
		super(vertices);
	}
}
