package com.codemelon.graph.edge;

import com.codemelon.graph.common.Color;

/**
 * @author Marshall Farrier
 * @my.created Dec 22, 2012
 * @my.edited Dec 22, 2012
 */
public class SpanningTreeEdgeData implements EdgeColorData, EdgeWeightData {
	private Color color;
	private double weight;
	
	public SpanningTreeEdgeData() {
		this(EdgeWeightData.DEFAULT_EDGE_WEIGHT, Color.WHITE);
	}
	
	public SpanningTreeEdgeData(double weight, Color color) {
		this.weight = weight;
		this.color = color;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.edge.EdgeWeightData#setWeight(double)
	 */
	@Override
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.edge.EdgeWeightData#getWeight()
	 */
	@Override
	public double getWeight() {
		return weight;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.edge.EdgeColorData#setColor(com.codemelon.graph.common.Color)
	 */
	@Override
	public void setColor(Color color) {
		this.color = color;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.edge.EdgeColorData#getColor()
	 */
	@Override
	public Color getColor() {
		return color;
	}
	public enum Factory implements EdgeDataFactory<SpanningTreeEdgeData> {
		INSTANCE;
		
		/**
		 * Factory method for creating new SpanningTreeEdgeData objects by calling the default constructor.
		 */
		@Override
		public SpanningTreeEdgeData newEdgeData() {
			return new SpanningTreeEdgeData();
		}		
	}
}
