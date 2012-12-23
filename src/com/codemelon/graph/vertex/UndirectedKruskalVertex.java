package com.codemelon.graph.vertex;

import com.codemelon.graph.common.Color;
import com.codemelon.graph.edge.EdgeDataFactory;
import com.codemelon.graph.edge.SpanningTreeEdgeData;

/**
 * Undirected vertex supporting the functions necessary for Kruskal's algorithm. This vertex
 * supports edge color and edge weight.
 * @author Marshall Farrier
 * @my.created Dec 22, 2012
 * @my.edited Dec 22, 2012
 */
public class UndirectedKruskalVertex<E extends SpanningTreeEdgeData, U extends EdgeDataFactory<E>> 
		extends UndirectedEdgeDataVertex<E, U> implements KruskalVertex<E> {

	public UndirectedKruskalVertex(U edgeDataFactory) {
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

	@Override
	public void setEdgeColor(EdgeColorVertex<E> to, Color color) {
		getEdgeData(to).setColor(color);
		to.getEdgeData(this).setColor(color);
	}

	@Override
	public Color getEdgeColor(EdgeColorVertex<E> to) {
		return getEdgeData(to).getColor();
	}
}
