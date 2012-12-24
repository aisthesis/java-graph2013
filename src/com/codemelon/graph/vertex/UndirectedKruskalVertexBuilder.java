package com.codemelon.graph.vertex;

import com.codemelon.graph.edge.EdgeDataFactory;
import com.codemelon.graph.edge.SpanningTreeEdgeData;

/**
 * @author Marshall Farrier
 * @my.created Dec 24, 2012
 * @my.edited Dec 24, 2012
 */
public class UndirectedKruskalVertexBuilder<E extends SpanningTreeEdgeData, U extends EdgeDataFactory<E>>
		implements VertexFactory<UndirectedKruskalVertex<E, U>>{
	private U edgeDataFactory;
	
	public UndirectedKruskalVertexBuilder(U edgeDataFactory) {
		this.edgeDataFactory = edgeDataFactory;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.VertexFactory#newVertex()
	 */
	@Override
	public UndirectedKruskalVertex<E, U> newVertex() {
		return new UndirectedKruskalVertex<E, U>(edgeDataFactory);
	}
}
