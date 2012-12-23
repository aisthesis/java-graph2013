package com.codemelon.graph.edge;

import com.codemelon.graph.graph.AbstractGraph;
import com.codemelon.graph.vertex.EdgeWeightVertex;
import com.codemelon.graph.vertex.UndirectedEdgeDataVertex;
import com.codemelon.graph.vertex.Vertex;

/**
 * Immutable, undirected edges that maintain a floating point weight.
 * Since the edge is undirected,
 * the distinction between head and tail or from and to is arbitrary.
 * Once the edge has been initialized, it will alway show the same from()
 * and to() vertices, but it is equivalent to an edge object having opposite
 * from() and to() vertices.
 * @author Marshall Farrier
 * @my.created Dec 20, 2012
 * @my.edited Dec 20, 2012
 */
public class UndirectedWeightedEdge<E extends EdgeWeightData, V extends UndirectedEdgeDataVertex<E, ?> & EdgeWeightVertex<E>> {
	private V from;
	private V to;
	/**
	 * @param from
	 * @param to
	 */
	public UndirectedWeightedEdge(V from, V to) {
		if (!from.containsAdjacency(to)) {
			throw new IllegalArgumentException("Edge does not exist!");
		}
		this.from = from;
		this.to = to;
	}
	/**
	 * Returns one end of the given edge. Note that the edge is undirected,
	 * so the distinction between head and tail or from and to is arbitrary.
	 * Once the edge has been initialized, it will always show the same from()
	 * and to() vertices, but it is equivalent to an edge object having opposite
	 * from() and to() vertices.
	 * @return the "from" vertex specified in the constructor
	 */
	public final V from() { return from; }
	/**
	 * Returns one end of the given edge. Note that the edge is undirected,
	 * so the distinction between head and tail or from and to is arbitrary.
	 * Once the edge has been initialized, it will alway show the same from()
	 * and to() vertices, but it is equivalent to an edge object having opposite
	 * from() and to() vertices.
	 * @return the "from" vertex specified in the constructor
	 */
	public final V to() { return to; }
	/**
	 * Returns the edge's weight.
	 * @return the edge's weight
	 */
	public final double weight() { 
		return from.getEdgeWeight(to); 
	}
	/**
	 * Get the graph to which the edge belongs
	 * @return the graph to which the edge belongs
	 */
	public final AbstractGraph<? extends Vertex> getGraph() {
		return from.getGraph();
	}
	/**
	 * Since weighted edges are undirected, they are equal not only if they
	 * have the same tail and head but also if they have opposite tails and heads.
	 * That is, 2 edges e1 and e2 are equal if either of the following conditions holds:
	 * <ol>
	 * <li>e1.from() == e2.from() && e1.to() == e2.to(), <em>or</em></li>
	 * <li>e1.from() == e2.to() && e1.to() == e2.from()</li>
	 * </ol>
	 */
	@Override
	public final boolean equals(Object o) {
		return (from == ((UndirectedWeightedEdge<?, ?>) o).from && to == ((UndirectedWeightedEdge<?, ?>) o).to) 
				|| (from == ((UndirectedWeightedEdge<?, ?>) o).to && to == ((UndirectedWeightedEdge<?, ?>) o).from);
	}
	/**
	 * Overridden so that adding weighted edges to a HashSet will automatically eliminate
	 * duplicates. We want edges that are equal (according to the equals() method) to have
	 * the same hash code.
	 */
	@Override
	public final int hashCode() {
		return from.hashCode() ^ to.hashCode();
	}
}
