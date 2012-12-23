package com.codemelon.graph.graph;

import java.util.Collection;
import java.util.Iterator;

import com.codemelon.graph.edge.EdgeDataFactory;
import com.codemelon.graph.vertex.UndirectedEdgeDataVertex;

/**
 * Undirected graph that supports edge data. The type parameter T is the type of the edge
 * data object, and U is an object containing a factory method for creating objects
 * of type T.
 * @author Marshall Farrier
 * @my.created Dec 16, 2012
 * @my.edited Dec 16, 2012
 */
public class UndirectedEdgeDataGraph<E, U extends EdgeDataFactory<E>, V extends UndirectedEdgeDataVertex<E, U>> 
		extends AbstractGraph<V> {
	/**
	 * Initialize graph to a default initial capacity of 16 vertices
	 */
	public UndirectedEdgeDataGraph() {
		super();
	}
	/**
	 * Initialize graph to have capacity for the given number of vertices
	 * @param initialCapacity expected number of vertices
	 */
	public UndirectedEdgeDataGraph(int initialCapacity) {
		super(initialCapacity);
	}
	/**
	 * Use the vertices in a collection as the initial vertices in the graph
	 * @param vertices collection of vertices that will make up the initial vertices
	 * of the graph
	 */
	public UndirectedEdgeDataGraph(Collection<V> vertices) {
		super(vertices);
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.graph.AbstractGraph#edgeCount()
	 */
	@Override
	public final int edgeCount() {
		int result = 0;
		Iterator<V> it = super.vertexIterator();
		while (it.hasNext()) {
			result += it.next().adjacencyCount();
		}
		return result / 2;
	}
}
