package com.codemelon.graph.vertex;

import java.util.Set;

import com.codemelon.graph.edge.EdgeDataFactory;

/**
 * @author Marshall Farrier
 * @my.created Dec 14, 2012
 * @my.edited Dec 14, 2012
 */
public class UndirectedEdgeDataVertex<T> extends DirectedEdgeDataVertex<T> {

	/**
	 * Constructor from an EdgeDataFactory
	 * @param edgeDataFactory factory to use for creating new EdgeData objects
	 */
	public UndirectedEdgeDataVertex(EdgeDataFactory<T> edgeDataFactory) {
		super(edgeDataFactory);
	}
	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.DirectedEdgeDataVertex#addAdjacency(com.codemelon.graph.vertex.Vertex)
	 */
	@Override
	public final <V extends Vertex> boolean addAdjacency(V to) {
		if (this.getGraph() == null || this.getGraph() != to.getGraph()) {
			throw new IllegalArgumentException("Adjacency must belong to the same graph!");
		}
		if (this == to) {
			throw new IllegalArgumentException("Self-edges not allowed in an undirected graph!");
		}
		if (this.containsAdjacency(to)) { return false; }
		super.addDirectedAdjacency(to);
		((DirectedEdgeDataVertex<?>) to).addDirectedAdjacency(this);
		return true;
	}
	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.DirectedEdgeDataVertex#removeAdjacency(com.codemelon.graph.vertex.Vertex)
	 */
	@Override
	public final boolean removeAdjacency(Vertex to) {
		if (this.containsAdjacency(to)) {
			super.removeDirectedAdjacency(to);
			((DirectedEdgeDataVertex<?>) to).removeDirectedAdjacency(this);
			return true;
		}
		return false;
	}
	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.DirectedEdgeDataVertex#clearAdjacencies()
	 */
	@Override
	public final void clearAdjacencies() {
		Set<? extends Vertex> adjacencies = super.getAdjacencies();
		for (Vertex v : adjacencies) {
			((DirectedEdgeDataVertex<?>) v).removeDirectedAdjacency(this);
		}
		super.clearAdjacencies();
	}
}
