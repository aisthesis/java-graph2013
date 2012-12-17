package com.codemelon.graph.vertex;

import com.codemelon.graph.common.Color;

/**
 * @author Marshall Farrier
 * @my.created Dec 17, 2012
 * @my.edited Dec 17, 2012
 */
public class DirectedSimpleColoredVertex extends DirectedSimpleVertex implements ColoredVertex {
	private Color color;

	/**
	 * Default constructor initializes graph to null, creates an empty adjacency list
	 * and initializes vertex color to WHITE
	 */
	public DirectedSimpleColoredVertex() {
		super();
		this.color = Color.WHITE;
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

}
