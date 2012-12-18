package com.codemelon.graph.graph;

import java.util.Collection;

import com.codemelon.graph.vertex.DirectedOrderedDfsVertex;

/**
 * @author Marshall Farrier
 * @my.created Dec 17, 2012
 * @my.edited Dec 17, 2012
 */
public enum OrderedDfsGraphFactory implements GraphFactory<DirectedOrderedDfsVertex> {
	INSTANCE;

	/* (non-Javadoc)
	 * @see com.codemelon.graph.graph.GraphFactory#newGraph()
	 */
	@Override
	public AbstractGraph<DirectedOrderedDfsVertex> newGraph() {
		return new DirectedSimpleGraph<DirectedOrderedDfsVertex>();
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.graph.GraphFactory#newGraph(int)
	 */
	@Override
	public AbstractGraph<DirectedOrderedDfsVertex> newGraph(int initialVertices) {
		return new DirectedSimpleGraph<DirectedOrderedDfsVertex>(initialVertices);
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.graph.GraphFactory#newGraph(java.util.Collection)
	 */
	@Override
	public AbstractGraph<DirectedOrderedDfsVertex> 
			newGraph(Collection<DirectedOrderedDfsVertex> vertices) {
		return new DirectedSimpleGraph<DirectedOrderedDfsVertex>(vertices);
	}
}
