package com.codemelon.graph.vertex;

import com.codemelon.graph.graph.AbstractGraph;

/**
 * @author Marshall Farrier
 * @my.created Dec 13, 2012
 * @my.edited Dec 13, 2012
 */
public abstract class AbstractVertex implements Vertex {
	private AbstractGraph<? extends Vertex> graph;
	/**
	 * Default constructor creates a vertex belonging to no graph
	 */
	public AbstractVertex() {
		graph = null;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.Vertex#setGraph(com.codemelon.graph.graph.Graph)
	 */
	@Override
	public final void setGraph(AbstractGraph<? extends Vertex> graph) {
		this.graph = graph;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.Vertex#getGraph()
	 */
	@Override
	public final AbstractGraph<? extends Vertex> getGraph() {
		return graph;
	}
	/**
	 * Don't allow subclasses to override the equals method
	 * @return true iff o points to exactly the same objects
	 */
	@Override
	public final boolean equals(Object o) {
		return (this == o);
	}
}