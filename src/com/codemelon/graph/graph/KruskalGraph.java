package com.codemelon.graph.graph;

import java.util.Collection;

import com.codemelon.graph.edge.EdgeDataFactory;
import com.codemelon.graph.edge.SpanningTreeEdgeData;
import com.codemelon.graph.vertex.UndirectedKruskalVertex;

/**
 * Utility class that eliminates one type parameter from UndirectedEdgeDataGraph<E, U, V> by specifying V
 * as an UndirectedDfsVertex<E, U>.
 * @author Marshall Farrier
 * @my.created Dec 22, 2012
 * @my.edited Dec 22, 2012
 */
public class KruskalGraph<E extends SpanningTreeEdgeData, U extends EdgeDataFactory<E>> 
		extends UndirectedEdgeDataGraph<E, U, UndirectedKruskalVertex<E, U>> {

	/**
	 * Initialize graph to a default initial capacity of 16 vertices
	 */
	public KruskalGraph() {
		super();
	}
	/**
	 * Use the vertices in a collection as the initial vertices in the graph
	 * @param vertices collection of vertices that will make up the initial vertices
	 * of the graph
	 */
	public KruskalGraph(Collection<UndirectedKruskalVertex<E, U>> vertices) {
		super(vertices);
	}
	/**
	 * Initialize graph to have capacity for the given number of vertices
	 * @param initialCapacity expected number of vertices
	 */
	public KruskalGraph(int initialCapacity) {
		super(initialCapacity);
	}
}
