package com.codemelon.graph.vertex;

import java.util.IdentityHashMap;
import java.util.Set;

import com.codemelon.graph.edge.EdgeDataFactory;

/**
 * @author Marshall Farrier
 * @my.created Dec 13, 2012
 * @my.edited Dec 13, 2012
 */
public class DirectedEdgeDataVertex<T> extends AbstractVertex implements EdgeDataVertex<T> {
	private EdgeDataFactory<T> edgeDataFactory;
	private IdentityHashMap<Vertex, T> adjacencies;
	
	/**
	 * Constructor from an EdgeDataFactory
	 * @param edgeDataFactory factory to use for creating new EdgeData objects
	 */
	public DirectedEdgeDataVertex(EdgeDataFactory<T> edgeDataFactory) {
		super();
		this.edgeDataFactory = edgeDataFactory;
		adjacencies = new IdentityHashMap<Vertex, T>();
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.Vertex#addAdjacency(com.codemelon.graph.vertex.Vertex)
	 */
	@Override
	public <V extends Vertex> boolean addAdjacency(V to) {
		if (this.getGraph() == null || this.getGraph() != to.getGraph()) {
			throw new IllegalArgumentException("Adjacency must belong to the same graph!");
		}
		if (adjacencies.containsKey(to)) { return false; }
		adjacencies.put(to, edgeDataFactory.newEdgeData());
		return true;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.Vertex#removeAdjacency(com.codemelon.graph.vertex.Vertex)
	 */
	@Override
	public boolean removeAdjacency(Vertex to) {
		if (adjacencies.containsKey(to)) {
			adjacencies.remove(to);
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.Vertex#clearAdjacencies()
	 */
	@Override
	public void clearAdjacencies() {
		adjacencies.clear();
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.Vertex#containsAdjacency(com.codemelon.graph.vertex.Vertex)
	 */
	@Override
	public final boolean containsAdjacency(Vertex to) {
		return adjacencies.containsKey(to);
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.Vertex#adjacencyCount()
	 */
	@Override
	public final int adjacencyCount() {
		return adjacencies.size();
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.Vertex#getAdjacencies()
	 */
	@Override
	public final Set<? extends Vertex> getAdjacencies() {
		return adjacencies.keySet();
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.Vertex#hasAdjacencies()
	 */
	@Override
	public final boolean hasAdjacencies() {
		return !adjacencies.isEmpty();
	}

	<V extends Vertex> void addDirectedAdjacency(V to) {
		adjacencies.put(to, edgeDataFactory.newEdgeData());
	}
	void removeDirectedAdjacency(Vertex to) {
		adjacencies.remove(to);
	}
	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.EdgeDataVertex#getEdgeData(com.codemelon.graph.vertex.EdgeDataVertex)
	 */
	@Override
	public T getEdgeData(EdgeDataVertex<T> to) {
		return adjacencies.get(to);
	}
}