package com.codemelon.graph.vertex;

import com.codemelon.graph.common.Color;
import com.codemelon.graph.edge.SpanningTreeEdgeData;

/**
 * @author Marshall Farrier
 * @my.created Dec 22, 2012
 * @my.edited Dec 22, 2012
 */
public class UndirectedKruskalVertex extends UndirectedEdgeDataVertex<SpanningTreeEdgeData, 
		SpanningTreeEdgeData.Factory> implements KruskalVertex<SpanningTreeEdgeData> {

	public UndirectedKruskalVertex() {
		super(SpanningTreeEdgeData.Factory.INSTANCE);
	}

	@Override
	public final void setEdgeWeight(EdgeWeightVertex<SpanningTreeEdgeData> to,
			double weight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final double getEdgeWeight(EdgeWeightVertex<SpanningTreeEdgeData> to) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public final void setEdgeColor(EdgeColorVertex<SpanningTreeEdgeData> to,
			Color color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final Color getEdgeColor(EdgeColorVertex<SpanningTreeEdgeData> to) {
		// TODO Auto-generated method stub
		return null;
	}
}
