package com.codemelon.graph.vertex;

import com.codemelon.graph.common.Color;
import com.codemelon.graph.edge.EdgeDataFactory;
import com.codemelon.graph.edge.SpanningTreeEdgeData;

/**
 * Undirected vertex supporting the functions necessary for Kruskal's algorithm. This vertex
 * supports edge color and edge weight.
 * @author Marshall Farrier
 * @my.created Dec 22, 2012
 * @my.edited Jan 08, 2013
 */
public class UndirectedKruskalVertex<E extends SpanningTreeEdgeData> 
		extends UndirectedEdgeDataVertex<E> implements KruskalVertex<E> {

	/**
	 * Construct vertex from a factory for building appropriate EdgeData objects.
	 * @param edgeDataFactory factory to use for constructing new EdgeData objects
	 */
	public UndirectedKruskalVertex(EdgeDataFactory<E> edgeDataFactory) {
		super(edgeDataFactory);
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.EdgeWeightVertex#setEdgeWeight(com.codemelon.graph.vertex.EdgeWeightVertex, double)
	 */
	@Override
	public final void setEdgeWeight(EdgeWeightVertex<E> to, double weight) {
		getEdgeData(to).setWeight(weight);
		to.getEdgeData(this).setWeight(weight);
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.EdgeWeightVertex#getEdgeWeight(com.codemelon.graph.vertex.EdgeWeightVertex)
	 */
	@Override
	public final double getEdgeWeight(EdgeWeightVertex<E> to) {
		return getEdgeData(to).getWeight();
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.EdgeColorVertex#setEdgeColor(com.codemelon.graph.vertex.EdgeColorVertex, com.codemelon.graph.common.Color)
	 */
	@Override
	public final void setEdgeColor(EdgeColorVertex<E> to, Color color) {
		getEdgeData(to).setColor(color);
		to.getEdgeData(this).setColor(color);
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.EdgeColorVertex#getEdgeColor(com.codemelon.graph.vertex.EdgeColorVertex)
	 */
	@Override
	public final Color getEdgeColor(EdgeColorVertex<E> to) {
		return getEdgeData(to).getColor();
	}
}
