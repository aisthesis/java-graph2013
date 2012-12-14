package com.codemelon.graph.vertex;

import java.util.HashSet;
import java.util.Set;

import com.codemelon.graph.vertex.Vertex;


/**
 * @author Marshall Farrier
 * @my.created Dec 13, 2012
 * @my.edited Dec 13, 2012
 */
public class DirectedSimpleVertex extends AbstractVertex {
	private Set<Vertex> adjacencies;

	/**
	 * Default constructor initializes graph to null and creates an empty adjacency list
	 */
	public DirectedSimpleVertex() {
		super();
		adjacencies = new HashSet<Vertex>();
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.Vertex#addAdjacency(com.codemelon.graph.vertex.Vertex)
	 */
	@Override
	public <T extends Vertex> boolean addAdjacency(T to) {
		if (this.getGraph() == null || this.getGraph() != to.getGraph()) {
			throw new IllegalArgumentException("Adjacency must belong to the same graph!");
		}
		if (adjacencies.contains(to)) { return false; }
		adjacencies.add(to);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.Vertex#removeAdjacency(com.codemelon.graph.vertex.Vertex)
	 */
	@Override
	public boolean removeAdjacency(Vertex to) {
		return adjacencies.remove(to);
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
	public boolean containsAdjacency(Vertex to) {
		return adjacencies.contains(to);
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
		return adjacencies;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.Vertex#hasAdjacencies()
	 */
	@Override
	public final boolean hasAdjacencies() {
		return !adjacencies.isEmpty();
	}

	<T extends Vertex> void addDirectedAdjacency(T to) {
		adjacencies.add(to);
	}
	boolean removeDirectedAdjacency(Vertex to) {
		return adjacencies.remove(to);
	}
}
