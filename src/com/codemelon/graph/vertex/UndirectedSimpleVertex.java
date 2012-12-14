package com.codemelon.graph.vertex;

import java.util.Set;

/**
 * Vertex to be used in undirected graphs. Adds and removes adjacencies
 * in both directions.
 * @author Marshall Farrier
 * @my.created Dec 13, 2012
 * @my.edited Dec 13, 2012
 */
public class UndirectedSimpleVertex extends DirectedSimpleVertex {
	/**
	 * Default constructor initializes graph to null and creates an empty adjacency list
	 */
	public UndirectedSimpleVertex() {
		super();
	}
	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.SimpleDirectedVertex#addAdjacency(com.codemelon.graph.vertex.Vertex)
	 */
	@Override
	public final <T extends Vertex> boolean addAdjacency(T to) {
		if (this.getGraph() == null || this.getGraph() != to.getGraph()) {
			throw new IllegalArgumentException("Adjacency must belong to the same graph!");
		}
		if (this == to) {
			throw new IllegalArgumentException("Self-edges not allowed in an undirected graph!");
		}
		if (this.containsAdjacency(to)) { return false; }
		this.addDirectedAdjacency(to);
		((DirectedSimpleVertex) to).addDirectedAdjacency(this);
		return true;
	}
	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.SimpleDirectedVertex#removeAdjacency(com.codemelon.graph.vertex.Vertex)
	 */
	@Override
	public final boolean removeAdjacency(Vertex to) {
		if (super.removeDirectedAdjacency(to)) {
			((DirectedSimpleVertex) to).removeDirectedAdjacency(this);
			return true;
		}
		return false;
	}
	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.SimpleDirectedVertex#clearAdjacencies()
	 */
	@Override
	public final void clearAdjacencies() {
		Set<? extends Vertex> adjacencies = super.getAdjacencies();
		for (Vertex v : adjacencies) {
			((DirectedSimpleVertex) v).removeDirectedAdjacency(this);
		}
		super.clearAdjacencies();
	}
}
