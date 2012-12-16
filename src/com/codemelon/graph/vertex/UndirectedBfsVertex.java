package com.codemelon.graph.vertex;

import com.codemelon.graph.common.Color;

/**
 * Undirected vertex supporting the operations required for breadth-first search.
 * @author Marshall Farrier
 * @my.created Dec 16, 2012
 * @my.edited Dec 16, 2012
 */
public class UndirectedBfsVertex extends UndirectedSimpleVertex implements
		BfsVertex {
	private Color color;
	private ChildVertex parent;
	private int distance;
	
	public UndirectedBfsVertex() {
		super();
		this.color = Color.WHITE;
		this.parent = null;
		this.distance = VertexConstants.DEFAULT_DISTANCE;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.ChildVertex#setParent(com.codemelon.graph.vertex.ChildVertex)
	 */
	@Override
	public void setParent(ChildVertex parent) {
		this.parent = parent;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.ChildVertex#getParent()
	 */
	@Override
	public ChildVertex getParent() {
		return parent;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.ColoredVertex#setColor(com.codemelon.graph.common.Color)
	 */
	@Override
	public void setColor(Color color) {
		this.color = color;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.ColoredVertex#getColor()
	 */
	@Override
	public Color getColor() {
		return color;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.DistanceVertex#setDistance(int)
	 */
	@Override
	public void setDistance(int distance) {
		this.distance = distance;
	}

	/* (non-Javadoc)
	 * @see com.codemelon.graph.vertex.DistanceVertex#getDistance()
	 */
	@Override
	public int getDistance() {
		return distance;
	}

}
