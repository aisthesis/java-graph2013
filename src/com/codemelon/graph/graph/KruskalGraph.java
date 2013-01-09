package com.codemelon.graph.graph;

import java.util.Collection;

import com.codemelon.graph.edge.SpanningTreeEdgeData;
import com.codemelon.graph.vertex.UndirectedKruskalVertex;

/**
 * Utility class that eliminates a type parameter from UndirectedWeightedEdgeGraph<E, U, V> by specifying V
 * as an UndirectedKruskalVertex<E, U>.
 * @author Marshall Farrier
 * @my.created Dec 22, 2012
 * @my.edited Dec 22, 2012
 */
public class KruskalGraph<E extends SpanningTreeEdgeData> 
		extends UndirectedWeightedEdgeGraph<E, UndirectedKruskalVertex<E>> {

	/**
	 * Use the vertices in a collection as the initial vertices in the graph and
	 * set weight epsilon to the specified value.
	 * @param vertices collection of vertices that will make up the initial vertices
	 * of the graph
	 * @param weightEpsilon weight epsilon to be used to determine weight equality
	 * in this graph
	 */
	public KruskalGraph(Collection<UndirectedKruskalVertex<E>> vertices,
			double weightEpsilon) {
		super(vertices, weightEpsilon);
	}

	/**
	 * Initialize an empty graph using the given value for weightEpsilon and default initial capacity. 
	 * The input value must be greater than 0.
	 * @param weightEpsilon weight epsilon to be used to determine weight equality
	 * in this graph
	 */
	public KruskalGraph(double weightEpsilon) {
		super(weightEpsilon);
	}
	/**
	 * Initialize an empty graph to have capacity for the given number of vertices and
	 * the specified weight epsilon.
	 * @param initialCapacity expected number of vertices in the graph
	 * @param weightEpsilon weight epsilon to be used to determine weight equality
	 * in this graph
	 */
	public KruskalGraph(int initialCapacity, double weightEpsilon) {
		super(initialCapacity, weightEpsilon);
	}
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
	public KruskalGraph(Collection<UndirectedKruskalVertex<E>> vertices) {
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
